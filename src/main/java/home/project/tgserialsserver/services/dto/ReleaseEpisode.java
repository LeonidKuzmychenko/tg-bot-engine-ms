package home.project.tgserialsserver.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReleaseEpisode {

    private String serialName;
    private Integer seasonNumber;
    private Integer episodeNumber;
    private String episodeName;
    private Set<Long> usersId = new HashSet<>();

}