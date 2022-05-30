package tg.project.engine.dtos;


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