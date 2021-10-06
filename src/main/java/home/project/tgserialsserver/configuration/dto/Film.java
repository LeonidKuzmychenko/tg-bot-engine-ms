package home.project.tgserialsserver.configuration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {

    @JsonProperty("filmId")
    private Long filmId;
    @JsonProperty("nameRu")
    private String nameRu;
    @JsonProperty("nameEn")
    private String nameEn;
    @JsonProperty("type")
    private String type;
    @JsonProperty("year")
    private String year;
    @JsonProperty("description")
    private String description;
    @JsonProperty("filmLength")
    private String filmLength;
    @JsonProperty("countries")
    private List<Country> countries = null;
    @JsonProperty("genres")
    private List<Genre> genres = null;
    @JsonProperty("rating")
    private String rating;
    @JsonProperty("ratingVoteCount")
    private Long ratingVoteCount;
    @JsonProperty("posterUrl")
    private String posterUrl;
    @JsonProperty("posterUrlPreview")
    private String posterUrlPreview;

}