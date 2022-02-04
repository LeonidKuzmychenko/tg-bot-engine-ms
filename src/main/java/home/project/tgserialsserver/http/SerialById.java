package home.project.tgserialsserver.http;

import home.project.tgserialsserver.http.parent.KinopoiskApi;
import home.project.tgserialsserver.http.parent.KinopoiskUrlProvider;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SerialById extends KinopoiskApi {

    public SerialById(RestTemplate restTemplate, KinopoiskUrlProvider urlProvider) {
        super(restTemplate, urlProvider);
    }

    public String get(String id) {
        String url = urlProvider.serialById(id);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, defaultEntity(), String.class);//TODO создать дто
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException();//TODO create custom exception
        }
    }

}
