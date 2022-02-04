package home.project.tgserialsserver.requests;

import home.project.tgserialsserver.properties.KinopoiskProperties;
import home.project.tgserialsserver.provider.KinopoiskUrlProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractKinopoiskRequest {

    private final KinopoiskProperties.Headers hProp;
    protected final RestTemplate restTemplate;
    protected final KinopoiskUrlProvider urlProvider;

    public AbstractKinopoiskRequest(KinopoiskProperties.Headers headers, @Qualifier("kinopoiskRestTemplate") RestTemplate restTemplate, KinopoiskUrlProvider urlProvider) {
        this.hProp = headers;
        this.restTemplate = restTemplate;
        this.urlProvider = urlProvider;
    }

    protected HttpEntity<Void> defaultEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(hProp.getAuthHeaderName(), hProp.getAuthHeaderValue());
        return new HttpEntity<>(headers);
    }
}