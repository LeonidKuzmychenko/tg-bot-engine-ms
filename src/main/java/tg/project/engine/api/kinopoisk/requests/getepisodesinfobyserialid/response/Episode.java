package tg.project.engine.api.kinopoisk.requests.getepisodesinfobyserialid.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Episode {

    @JsonProperty("seasonNumber")
    private Integer seasonNumber;

    @JsonProperty("episodeNumber")
    private Integer episodeNumber;

    @JsonProperty("nameRu")
    private String nameRu;

    @JsonProperty("nameEn")
    private String nameEn;

    @JsonProperty("synopsis")
    private String synopsis;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("releaseDate")
    private LocalDate releaseDate;
}