package home.project.tgserialsserver.http;

import home.project.tgserialsserver.http.parent.KinopoiskApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class SearchByName extends KinopoiskApi {

    @Value("${kinopoisk-api-unofficial.search-by-text}")
    private String path;

    public String get(String text) {
        String url = UriComponentsBuilder.newInstance().scheme(scheme)
                .host(host).path(path).queryParam("keyword", text).toString();
        ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.GET, httpEntity, String.class);//TODO создать дто
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException();//TODO create custom exception
        }
    }
}
