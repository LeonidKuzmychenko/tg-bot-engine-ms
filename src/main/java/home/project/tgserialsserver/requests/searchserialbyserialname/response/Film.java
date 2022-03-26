package home.project.tgserialsserver.requests.searchserialbyserialname.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import home.project.tgserialsserver.requests.searchserialbyserialname.dto.SearchByNameDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {

    @JsonProperty("filmId")
    public Long filmId;
    @JsonProperty("nameRu")
    public String nameRu;
    @JsonProperty("nameEn")
    public String nameEn;
    @JsonProperty("type")
    public String type;
    @JsonProperty("year")
    public String year;
    @JsonProperty("description")
    public String description;
    @JsonProperty("filmLength")
    public String filmLength;
    @JsonProperty("countries")
    public List<Country> countries = null;
    @JsonProperty("genres")
    public List<Genre> genres = null;
    @JsonProperty("rating")
    public String rating;
    @JsonProperty("ratingVoteCount")
    public Long ratingVoteCount;
    @JsonProperty("posterUrl")
    public String posterUrl;
    @JsonProperty("posterUrlPreview")
    public String posterUrlPreview;

    public SearchByNameDto toSearchByNameDto() {
        SearchByNameDto searchByNameDto = new SearchByNameDto();
        searchByNameDto.setNameRu(this.nameRu);
        searchByNameDto.setNameEn(this.nameEn);
        searchByNameDto.setPosterUrl(this.posterUrl);
        return searchByNameDto;
    }
}