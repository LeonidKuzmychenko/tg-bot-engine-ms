package tg.project.engine.services;

import org.springframework.stereotype.Service;
import tg.project.engine.api.kinopoisk.requests.getepisodesinfobyserialid.response.SerialsWhatReleaseTodayDto;
import tg.project.engine.dtos.FormattedEpisodeDto;
import tg.project.engine.mapper.EpisodeMapper;
import tg.project.engine.provider.CollectorProvider;

@Service
public class MessageService {

    private final EpisodeMapper episodeMapper;

    public MessageService(EpisodeMapper episodeMapper) {
        this.episodeMapper = episodeMapper;
    }

    /**
     * Формировка текст сообщения для ТГ бота
     */
    public String getMessageFromSerialsWhatReleaseToday(SerialsWhatReleaseTodayDto rEpisodes) {
        return rEpisodes.getReleasesEpisode().stream()
                .map(episodeMapper::toFormattedEpisode)
                .map(FormattedEpisodeDto::format)
                .collect(CollectorProvider.toEpisodesMessage(rEpisodes.getSerialName()));
    }

}