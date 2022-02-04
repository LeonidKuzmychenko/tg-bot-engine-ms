package home.project.tgserialsserver.configuration;

import home.project.tgserialsserver.properties.KinopoiskProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

import static java.util.Collections.singletonList;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Configuration
public class KinopoiskConfiguration {

    @Bean("kinopoiskRestTemplate")
    public RestTemplate kinopoiskRestTemplate(final ClientHttpRequestInterceptor interceptor) {
        final RestTemplateBuilder builder = new RestTemplateBuilder();
        builder.interceptors(interceptor);
        builder.setConnectTimeout(Duration.ofSeconds(30));
        builder.setReadTimeout(Duration.ofSeconds(30));
        return builder.build();
    }

    @Bean
    public ClientHttpRequestInterceptor getHeaderInterceptor(KinopoiskProperties.Headers headers) {
        return (request, body, execution) -> {
            request.getHeaders().set(headers.getAuthHeaderName(), headers.getAuthHeaderValue());
            request.getHeaders().setAccept(singletonList(APPLICATION_JSON));
            return execution.execute(request, body);
        };
    }

}