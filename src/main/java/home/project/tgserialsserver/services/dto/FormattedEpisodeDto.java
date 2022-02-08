package home.project.tgserialsserver.services.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormattedEpisodeDto {
    private Integer seasonNumber;
    private Integer episodeNumber;
    private String name;

    public String format() {
        return String.format("%d серия %d сезона - %s", episodeNumber, seasonNumber, name);
    }
}