package tg.project.engine.services;

import org.springframework.stereotype.Service;
import tg.project.engine.api.db.requests.serial.SerialService;
import tg.project.engine.api.kinopoisk.requests.getepisodesinfobyserialid.GetEpisodesInfoBySerialIdRequest;
import tg.project.engine.api.kinopoisk.requests.getepisodesinfobyserialid.response.SerialsWhatReleaseTodayDto;
import tg.project.engine.utils.Sleeper;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SerialsWhatReleaseTodayService {

    private final Sleeper sleeper;
    private final GetEpisodesInfoBySerialIdRequest getEpisodesInfoBySerialIdRequest;
    private final SerialService serialService;

    public SerialsWhatReleaseTodayService(Sleeper sleeper, GetEpisodesInfoBySerialIdRequest getEpisodesInfoBySerialIdRequest, SerialService serialService) {
        this.sleeper = sleeper;
        this.getEpisodesInfoBySerialIdRequest = getEpisodesInfoBySerialIdRequest;
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
                .map(this::getSerialTodayReleaseEpisodesBySerialId)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    private SerialsWhatReleaseTodayDto getSerialTodayReleaseEpisodesBySerialId(Long serialId) {
        sleeper.ms(100);
        return getEpisodesInfoBySerialIdRequest.get(serialId);
    }

}
