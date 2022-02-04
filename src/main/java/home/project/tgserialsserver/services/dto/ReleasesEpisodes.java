package home.project.tgserialsserver.services.dto;

import home.project.tgserialsserver.requests.getepisodesinfobyserialid.response.Episode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReleasesEpisodes {

    private Long serialId;
    private List<Episode> episodes = new ArrayList<>();
}