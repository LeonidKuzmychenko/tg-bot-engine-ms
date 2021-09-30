package home.project.tgserialsserver.configuration.web;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Collections;

@Configuration
public class ApiHeaderConfiguration {

    @Value("${kinopoisk-api-unofficial.token}")
    private String token;

    @Bean("ApiTokenHeader")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public HttpHeaders getApiHttpHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-API-KEY", token);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return headers;
    }

    @Bean("ApiTokenEntity")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public HttpEntity<Void> getApiHttpEntity(@Qualifier("ApiTokenHeader") HttpHeaders httpHeaders) {
        return new HttpEntity<>(httpHeaders);
    }
}
