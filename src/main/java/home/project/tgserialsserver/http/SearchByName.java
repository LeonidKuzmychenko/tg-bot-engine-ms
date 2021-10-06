package home.project.tgserialsserver.http;

import home.project.tgserialsserver.configuration.dto.Film;
import home.project.tgserialsserver.configuration.dto.SearchByNameDto;
import home.project.tgserialsserver.exceptions.SearchByNameException;
import home.project.tgserialsserver.http.parent.KinopoiskApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Component
public class SearchByName extends KinopoiskApi {

    @Value("${kinopoisk-api-unofficial.search-by-text}")
    private String path;

    public Film get(String text) {
        String url = UriComponentsBuilder.newInstance().scheme(scheme)
                .host(host).path(path).queryParam("keyword", text).build().toString();
        ResponseEntity<SearchByNameDto> response = new RestTemplate().exchange(url, HttpMethod.GET, httpEntity, SearchByNameDto.class);//TODO создать дто
        if (response.getStatusCode() != HttpStatus.OK) {
            throw SearchByNameException.requestError();
        }
        SearchByNameDto searchByNameDto = response.getBody();
        if (searchByNameDto == null) {
            throw SearchByNameException.bodyIsNull();
        }

        List<Film> films = searchByNameDto.getFilms();
        if (films.isEmpty()) {
            throw SearchByNameException.filmNotFound();
        }
        return films.get(0);

    }
}

