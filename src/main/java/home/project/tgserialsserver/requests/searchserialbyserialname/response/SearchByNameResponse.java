package home.project.tgserialsserver.requests.searchserialbyserialname.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchByNameResponse {

    @JsonProperty("keyword")
    public String keyword;
    @JsonProperty("pagesCount")
    public Long pagesCount;
    @JsonProperty("films")
    public List<Film> films = new ArrayList<>();
    @JsonProperty("searchFilmsCountResult")
    public Long searchFilmsCountResult;

}