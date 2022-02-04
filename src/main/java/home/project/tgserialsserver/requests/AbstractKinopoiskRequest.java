package home.project.tgserialsserver.requests;

import home.project.tgserialsserver.provider.KinopoiskUrlProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractKinopoiskRequest {

    protected final RestTemplate restTemplate;
    protected final KinopoiskUrlProvider urlProvider;

    public AbstractKinopoiskRequest(@Qualifier("kinopoiskRestTemplate") RestTemplate restTemplate, KinopoiskUrlProvider urlProvider) {
        this.restTemplate = restTemplate;
        this.urlProvider = urlProvider;
    }

    protected HttpEntity<Void> defaultEntity() {
        return new HttpEntity<>(new HttpHeaders());
    }
}