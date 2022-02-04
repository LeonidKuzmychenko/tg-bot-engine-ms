package home.project.tgserialsserver.services.dto;


import home.project.tgserialsserver.requests.getepisodesinfobyserialid.response.Episode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormattedEpisode {
    private Integer seasonNumber;
    private Integer episodeNumber;
    private String name;

    public static FormattedEpisode newInstance(Episode episode) {
        String name = "";
        if (StringUtils.hasLength(episode.getNameRu())) {
            name = episode.getNameRu();
        }
        if (StringUtils.hasLength(episode.getNameEn())) {
            name = episode.getNameEn();
        }
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
