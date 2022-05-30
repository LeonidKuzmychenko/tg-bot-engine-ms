package tg.project.engine.api.kinopoisk.requests.searchserialbyserialname;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tg.project.engine.api.kinopoisk.providers.KinopoiskUrlProvider;
import tg.project.engine.api.kinopoisk.requests.searchserialbyserialname.response.SearchByNameResponse;
import tg.project.engine.exceptions.SearchByNameException;

import static org.springframework.http.HttpMethod.GET;
import static tg.project.engine.provider.HeadersProvider.defaultEntity;

@Component
public class SearchSerialBySerialNameRequest {

    private final RestTemplate restTemplate;
    private final KinopoiskUrlProvider urlProvider;

    public SearchSerialBySerialNameRequest(RestTemplate restTemplate, KinopoiskUrlProvider urlProvider) {
        this.restTemplate = restTemplate;
        this.urlProvider = urlProvider;
    }

    public SearchByNameResponse get(String text) {
        String url = urlProvider.searchSerialBySerialName(text);
        ResponseEntity<SearchByNameResponse> response = restTemplate.exchange(url, GET, defaultEntity(), SearchByNameResponse.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw SearchByNameException.requestError();
        }
        SearchByNameResponse searchByNameResponse = response.getBody();
        if (searchByNameResponse == null) {
            throw SearchByNameException.bodyIsNull();
        }
        return searchByNameResponse;
    }
}