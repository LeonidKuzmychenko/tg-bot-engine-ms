package home.project.tgserialsserver.services;

import home.project.tgserialsserver.requests.getepisodesinfobyserialid.GetEpisodesInfoBySerialIdRequest;
import home.project.tgserialsserver.requests.getepisodesinfobyserialid.response.Episode;
import home.project.tgserialsserver.requests.getepisodesinfobyserialid.response.GetEpisodesInfoBySerialIdResponseDto;
import home.project.tgserialsserver.requests.getepisodesinfobyserialid.response.Item;
import home.project.tgserialsserver.requests.getserialinfobyserialid.GetSerialInfoBySerialIdRequest;
import home.project.tgserialsserver.requests.getserialinfobyserialid.response.GetSerialInfoBySerialIdResponseDto;
import home.project.tgserialsserver.services.dto.ReleaseEpisode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.util.StringUtils.hasLength;

@Slf4j
@Service
public class SubscribeSerialService {

    private final String MESSAGE_SCHEMA = "Сегодня выходит %d серия %d сезона сериала %s: \"%s\"";


    private final GetSerialInfoBySerialIdRequest getSerialInfoBySerialIdRequest;
    private final GetEpisodesInfoBySerialIdRequest getEpisodesInfoBySerialIdRequest;
    private final SerialService serialService;
    private final UserService userService;

    public SubscribeSerialService(GetSerialInfoBySerialIdRequest getSerialInfoBySerialIdRequest, GetEpisodesInfoBySerialIdRequest getEpisodesInfoBySerialIdRequest, SerialService serialService, UserService userService) {
        this.getSerialInfoBySerialIdRequest = getSerialInfoBySerialIdRequest;
        this.getEpisodesInfoBySerialIdRequest = getEpisodesInfoBySerialIdRequest;
        this.serialService = serialService;
        this.userService = userService;
    }

    public void checkSubscribe() {
        Set<Long> uniqueSubscribedSerials = serialService.getUniqueSubscribedSerials();
        log.info("UniqueSubscribedSerials: {}", uniqueSubscribedSerials);
        uniqueSubscribedSerials.stream()
                .flatMap(this::getTodayReleasesEpisodesWithDelay)
                .forEach(releaseEpisode -> sendMessageToUser());
    }

    public void sendMessageToUser() {

    }

    private Stream<ReleaseEpisode> getTodayReleasesEpisodesWithDelay(Long serialId) {
        Stream<ReleaseEpisode> releaseEpisodes = null;
        List<Episode> episodes = getTodayReleasesEpisodes(serialId);
        if (episodes != null && !episodes.isEmpty()) {
            String serialName = getSerialNameBySerialId(serialId);
            Set<Long> allUsersWhoSubscribeSerialByApiId = userService.getAllUsersWhoSubscribeSerialByApiId(serialId);
            releaseEpisodes = episodes.stream()
                    .map(episode -> initReleaseEpisode(episode, serialName, allUsersWhoSubscribeSerialByApiId));
        }
        sleep();
        return releaseEpisodes;
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private ReleaseEpisode initReleaseEpisode(Episode episode, String serialName, Set<Long> allUsersWhoSubscribeSerialByApiId) {
        String name = hasLength(episode.getNameRu()) ? episode.getNameRu() : episode.getNameEn();
        ReleaseEpisode releaseEpisode = new ReleaseEpisode();
        releaseEpisode.setSerialName(serialName);
        releaseEpisode.setUsersId(allUsersWhoSubscribeSerialByApiId);
        releaseEpisode.setSeasonNumber(episode.getSeasonNumber());
        releaseEpisode.setEpisodeNumber(episode.getEpisodeNumber());
        releaseEpisode.setEpisodeName(name);
        return releaseEpisode;
    }

    private String getSerialNameBySerialId(Long serialId) {
        Optional<GetSerialInfoBySerialIdResponseDto> oSerialInfo = getSerialInfoBySerialIdRequest.execute(serialId);
        if (oSerialInfo.isPresent()) {
            GetSerialInfoBySerialIdResponseDto serialInfo = oSerialInfo.get();
            return hasLength(serialInfo.getNameRu()) ? serialInfo.getNameRu() : serialInfo.getNameEn();
        }
        return "NaN";
    }

    private List<Episode> getTodayReleasesEpisodes(Long serialId) {
        Optional<GetEpisodesInfoBySerialIdResponseDto> oSerial = getEpisodesInfoBySerialIdRequest.execute(serialId);
        if (oSerial.isPresent()) {
            List<Item> items = oSerial.get().getItems();
            if (items != null && !items.isEmpty()) {
                return filterEpisodes(items);
            }
        }
        return null;
    }

    private List<Episode> filterEpisodes(List<Item> items) {
        return items.stream()
                .map(Item::getEpisodes)
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(episode -> hasLength(episode.getNameEn()))
                .filter(episode -> episode.getReleaseDate() != null)
                .filter(episode -> {
                    LocalDate releaseDate = episode.getReleaseDate();
                    return LocalDate.now().isEqual(releaseDate);
                })
                .collect(Collectors.toList());
    }
}