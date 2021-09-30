package home.project.tgserialsserver.http;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class SerialById extends KinopoiskApi {

    @Value("${kinopoisk-api-unofficial.serial-by-id}")
    private String path;

    public String get(String id) {
        String url = UriComponentsBuilder.newInstance().scheme(scheme)
                .host(host).path(path).buildAndExpand(id).toString();
        ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.GET, httpEntity, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException();
        }
    }

}
