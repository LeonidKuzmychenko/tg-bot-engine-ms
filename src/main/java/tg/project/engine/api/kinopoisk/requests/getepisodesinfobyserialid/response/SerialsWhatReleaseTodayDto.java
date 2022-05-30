package tg.project.engine.api.kinopoisk.requests.getepisodesinfobyserialid.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SerialsWhatReleaseTodayDto {

    private Long serialId;
    private String serialName;
    private List<Episode> releasesEpisode = new ArrayList<>();
}