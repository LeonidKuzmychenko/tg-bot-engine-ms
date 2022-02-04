package home.project.tgserialsserver.services;

import home.project.tgserialsserver.requests.getepisodesinfobyserialid.GetEpisodesInfoBySerialIdRequest;
import home.project.tgserialsserver.requests.getepisodesinfobyserialid.response.Episode;
import home.project.tgserialsserver.requests.getepisodesinfobyserialid.response.GetEpisodesInfoBySerialIdResponseDto;
import home.project.tgserialsserver.requests.getepisodesinfobyserialid.response.Item;
import home.project.tgserialsserver.services.dto.ReleasesEpisodes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SubscribeSerialService {

    private final String MESSAGE_SCHEMA = "Сегодня выходит %d серия %d сезона сериала %s: \"%s\"";


    private final GetEpisodesInfoBySerialIdRequest getEpisodesInfoBySerialIdRequest;
    private final SerialService serialService;
    private final UserService userService;

    public SubscribeSerialService(GetEpisodesInfoBySerialIdRequest getEpisodesInfoBySerialIdRequest, SerialService serialService, UserService userService) {
        this.getEpisodesInfoBySerialIdRequest = getEpisodesInfoBySerialIdRequest;
        this.serialService = serialService;
        this.userService = userService;
    }

    public void checkSubscribe() {
        Set<Long> uniqueSubscribedSerials = serialService.getUniqueSubscribedSerials();
        log.info("UniqueSubscribedSerials: {}", uniqueSubscribedSerials);
        uniqueSubscribedSerials.stream()
                .map(this::getTodayReleasesEpisodesWithDelay);
    }

    private ReleasesEpisodes getTodayReleasesEpisodesWithDelay(Long serialId) {
        List<Episode> episodes = getTodayReleasesEpisodes(serialId);
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return episodes == null || episodes.isEmpty() ? null : new ReleasesEpisodes(serialId, episodes);
    }


    private List<Episode> getTodayReleasesEpisodes(Long serialId) {
        Optional<GetEpisodesInfoBySerialIdResponseDto> oSerial = getEpisodesInfoBySerialIdRequest.execute(serialId);
        if (oSerial.isPresent()) {
            List<Item> items = oSerial.get().getItems();
            if (items != null && !items.isEmpty()) {
                return items.stream()
                        .map(Item::getEpisodes)
                        .flatMap(Collection::stream)
                        .filter(Objects::nonNull)
                        .filter(episode -> StringUtils.hasLength(episode.getNameEn()))
                        .filter(episode -> episode.getReleaseDate() != null)
                        .filter(episode -> {
                            LocalDate releaseDate = episode.getReleaseDate();
                            return LocalDate.now().isEqual(releaseDate);
                        })
                        .collect(Collectors.toList());
            }
        }
        return null;
    }
}
