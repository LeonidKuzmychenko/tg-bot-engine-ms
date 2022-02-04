package home.project.tgserialsserver.services;

import home.project.tgserialsserver.requests.getepisodesinfobyserialid.GetEpisodesInfoBySerialIdRequest;
import home.project.tgserialsserver.requests.getepisodesinfobyserialid.response.Episode;
import home.project.tgserialsserver.requests.getepisodesinfobyserialid.response.GetEpisodesInfoBySerialIdResponseDto;
import home.project.tgserialsserver.requests.getepisodesinfobyserialid.response.Item;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GetEpisodesInfoBySerialIdService {

    private final GetEpisodesInfoBySerialIdRequest getEpisodesInfoBySerialIdRequest;

    public GetEpisodesInfoBySerialIdService(GetEpisodesInfoBySerialIdRequest getEpisodesInfoBySerialIdRequest) {
        this.getEpisodesInfoBySerialIdRequest = getEpisodesInfoBySerialIdRequest;
    }

    public List<Episode> getTodayReleasesEpisodes(Long serialId) {
        //Достаю все эпизоды сериала
        Optional<GetEpisodesInfoBySerialIdResponseDto> oSerial = getEpisodesInfoBySerialIdRequest.execute(serialId);
        if (oSerial.isPresent()) {
            List<Item> items = oSerial.get().getItems();
            if (items != null && !items.isEmpty()) {
                //Фильтрую все эпизоды на те, у которых есть название и дата выхода сегодня
                return filterTodayReleasesEpisodes(items);
            }
        }
        return null;
    }

    private List<Episode> filterTodayReleasesEpisodes(List<Item> items) {
        return items.stream()
                .map(Item::getEpisodes)
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(episode -> episode.getReleaseDate() != null)
                .filter(episode -> {
                    LocalDate releaseDate = episode.getReleaseDate();
                    return LocalDate.now().isEqual(releaseDate);
                })
                .collect(Collectors.toList());
    }
}