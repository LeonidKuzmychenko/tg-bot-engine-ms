package tg.project.engine.provider;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

public class HeadersProvider {

    public static HttpEntity<Void> defaultEntity() {
        return new HttpEntity<>(new HttpHeaders());
    }

}