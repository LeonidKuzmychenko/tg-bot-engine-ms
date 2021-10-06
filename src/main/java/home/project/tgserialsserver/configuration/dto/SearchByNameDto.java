package home.project.tgserialsserver.configuration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchByNameDto {

    @JsonProperty("keyword")
    private String keyword;
    @JsonProperty("pagesCount")
    private Long pagesCount;
    @JsonProperty("films")
    private List<Film> films = null;
    @JsonProperty("searchFilmsCountResult")
    private Long searchFilmsCountResult;

}