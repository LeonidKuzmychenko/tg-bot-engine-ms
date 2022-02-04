package home.project.tgserialsserver.http.parent;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public abstract class KinopoiskApi {

    protected final RestTemplate restTemplate;
    protected final KinopoiskUrlProvider urlProvider;

    public KinopoiskApi(@Qualifier("kinopoiskRestTemplate") RestTemplate restTemplate, KinopoiskUrlProvider urlProvider) {
        this.restTemplate = restTemplate;
        this.urlProvider = urlProvider;
    }

    protected HttpEntity<Void> defaultEntity() {
        return new HttpEntity<>(new HttpHeaders());
    }
}