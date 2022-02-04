package home.project.tgserialsserver.services;

import home.project.tgserialsserver.repository.SerialRepository;
import home.project.tgserialsserver.requests.getepisodesinfobyserialid.response.Episode;
import home.project.tgserialsserver.services.dto.SerialsWhatReleaseToday;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class SerialService {

    private final GetEpisodesInfoBySerialIdService episodesInfoBySerialIdService;
    private final GetSerialInfoBySerialIdService serialInfoBySerialIdService;
    private final SerialRepository repository;

    public SerialService(GetSerialInfoBySerialIdService serialInfoBySerialIdService, GetEpisodesInfoBySerialIdService episodesInfoBySerialIdService, SerialRepository repository) {
        this.serialInfoBySerialIdService = serialInfoBySerialIdService;
        this.episodesInfoBySerialIdService = episodesInfoBySerialIdService;
        this.repository = repository;
    }

    /**
     * Достать все сериалы, серии которых вышли сегодня
     */
    public List<SerialsWhatReleaseToday> getSerialsWhatReleaseToday() {
        //Достаю все сериалы, на которые хоть кто-то подписан.
        Set<Long> uniqueSubscribedSerials = repository.getUniqueSubscribedSerials();
        //Формирую список из сериалов с эпизодами, которые сегодня выходят
        return uniqueSubscribedSerials.stream()
                .map(serialId -> {
                    //Достаю все серии сериала, которые сегодня вышли
                    List<Episode> episodes = episodesInfoBySerialIdService.getTodayReleasesEpisodes(serialId);
                    SerialsWhatReleaseToday serialsWhatReleaseToday = null;
                    if (episodes != null && !episodes.isEmpty()) {
                        //Если список серий не пустой, то достаю название сериала
                        String serialName = serialInfoBySerialIdService.getSerialNameBySerialId(serialId);
                        serialsWhatReleaseToday = new SerialsWhatReleaseToday();
                        serialsWhatReleaseToday.setSerialId(serialId);
                        serialsWhatReleaseToday.setSerialName(serialName);
                        serialsWhatReleaseToday.setReleasesEpisode(episodes);
                    }
                    //Чтобы не заспамить АПИ, делаю паузы между запросами
                    sleep();
                    return serialsWhatReleaseToday;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}