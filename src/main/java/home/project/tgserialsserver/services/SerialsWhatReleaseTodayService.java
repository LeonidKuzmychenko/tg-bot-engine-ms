package home.project.tgserialsserver.services;

import home.project.tgserialsserver.requests.getepisodesinfobyserialid.response.Episode;
import home.project.tgserialsserver.services.dto.SerialsWhatReleaseTodayDto;
import home.project.tgserialsserver.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SerialsWhatReleaseTodayService {

    private final Utils utils;
    private final GetEpisodesInfoBySerialIdService episodesInfoBySerialIdService;
    private final GetSerialInfoBySerialIdService serialInfoBySerialIdService;
    private final SerialService serialService;

    public SerialsWhatReleaseTodayService(Utils utils, GetEpisodesInfoBySerialIdService episodesInfoBySerialIdService, GetSerialInfoBySerialIdService serialInfoBySerialIdService, SerialService serialService) {
        this.utils = utils;
        this.episodesInfoBySerialIdService = episodesInfoBySerialIdService;
        this.serialInfoBySerialIdService = serialInfoBySerialIdService;
        this.serialService = serialService;
    }

    /**
     * Достать все сериалы, серии которых вышли сегодня
     */
    public Set<SerialsWhatReleaseTodayDto> getSerialsWhatReleaseToday() {
        //Достаю все сериалы, на которые хоть кто-то подписан.
        Set<Long> uniqueSubscribedSerials = serialService.getUniqueSubscribedSerials();
        //Формирую список из сериалов с эпизодами, которые сегодня выходят
        return uniqueSubscribedSerials.stream()
                .map(this::getSerialsWhatReleaseTodayBySerialId)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    private SerialsWhatReleaseTodayDto getSerialsWhatReleaseTodayBySerialId(Long serialId) {
        //Достаю все серии сериала, которые сегодня вышли
        List<Episode> episodes = episodesInfoBySerialIdService.getTodayReleasesEpisodes(serialId);
        SerialsWhatReleaseTodayDto serialsWhatReleaseTodayDto = null;
        if (episodes != null && !episodes.isEmpty()) {
            //Если список серий не пустой, то достаю название сериала
            String serialName = serialInfoBySerialIdService.getSerialNameBySerialId(serialId);
            serialsWhatReleaseTodayDto = new SerialsWhatReleaseTodayDto(serialId, serialName, episodes);
        }
        //Чтобы не заспамить АПИ, делаю паузы между запросами
        utils.sleep();
        return serialsWhatReleaseTodayDto;
    }

}
