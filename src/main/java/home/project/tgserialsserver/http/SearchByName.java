package home.project.tgserialsserver.http;

import home.project.tgserialsserver.configuration.dto.Film;
import home.project.tgserialsserver.configuration.dto.SearchByNameDto;
import home.project.tgserialsserver.exceptions.SearchByNameException;
import home.project.tgserialsserver.http.parent.KinopoiskApi;
import home.project.tgserialsserver.http.parent.KinopoiskUrlProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Component
public class SearchByName extends KinopoiskApi {

    public SearchByName(RestTemplate restTemplate, KinopoiskUrlProvider urlProvider) {
        super(restTemplate, urlProvider);
    }

    public Film get(String text) {
        String url = urlProvider.searchByText(text);
        ResponseEntity<SearchByNameDto> response = restTemplate.exchange(url, GET, defaultEntity(), SearchByNameDto.class);
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

