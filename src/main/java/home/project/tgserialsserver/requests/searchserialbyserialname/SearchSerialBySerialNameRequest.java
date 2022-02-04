package home.project.tgserialsserver.requests.searchserialbyserialname;

import home.project.tgserialsserver.provider.KinopoiskUrlProvider;
import home.project.tgserialsserver.requests.AbstractKinopoiskRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SearchSerialBySerialNameRequest extends AbstractKinopoiskRequest {

    public SearchSerialBySerialNameRequest(RestTemplate restTemplate, KinopoiskUrlProvider urlProvider) {
        super(restTemplate, urlProvider);
    }

//    public Film get(String text) {
//        String url = urlProvider.searchByText(text);
//        ResponseEntity<SearchByNameDto> response = restTemplate.exchange(url, GET, defaultEntity(), SearchByNameDto.class);
//        if (response.getStatusCode() != HttpStatus.OK) {
//            throw SearchByNameException.requestError();
//        }
//        SearchByNameDto searchByNameDto = response.getBody();
//        if (searchByNameDto == null) {
//            throw SearchByNameException.bodyIsNull();
//        }
//        List<Film> films = searchByNameDto.getFilms();
//        if (films.isEmpty()) {
//            throw SearchByNameException.filmNotFound();
//        }
//        return films.get(0);
//    }
}