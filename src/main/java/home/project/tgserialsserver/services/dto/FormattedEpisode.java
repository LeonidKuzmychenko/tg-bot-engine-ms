package home.project.tgserialsserver.services.dto;


import home.project.tgserialsserver.requests.getepisodesinfobyserialid.response.Episode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.springframework.util.StringUtils.hasLength;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormattedEpisode {
    private Integer seasonNumber;
    private Integer episodeNumber;
    private String name;

    public static FormattedEpisode newInstance(Episode episode) {
        String name = hasLength(episode.getNameRu()) ? episode.getNameRu() : episode.getNameEn();
        FormattedEpisode formattedEpisode = new FormattedEpisode();
        formattedEpisode.setEpisodeNumber(episode.getEpisodeNumber());
        formattedEpisode.setSeasonNumber(episode.getSeasonNumber());
        formattedEpisode.setName(name);
        return formattedEpisode;
    }

    public String format() {
        return String.format("%d серия %d сезона - %s", episodeNumber, seasonNumber, name);
    }
}
