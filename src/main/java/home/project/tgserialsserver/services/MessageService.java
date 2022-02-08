package home.project.tgserialsserver.services;

import home.project.tgserialsserver.mapper.EpisodeMapper;
import home.project.tgserialsserver.provider.CollectorProvider;
import home.project.tgserialsserver.services.dto.FormattedEpisodeDto;
import home.project.tgserialsserver.services.dto.SerialsWhatReleaseTodayDto;
import org.springframework.stereotype.Service;

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