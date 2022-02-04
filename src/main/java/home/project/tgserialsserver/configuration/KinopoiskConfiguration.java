package home.project.tgserialsserver.configuration;

import home.project.tgserialsserver.properties.KinopoiskProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class KinopoiskConfiguration {

    @Bean("kinopoiskRestTemplate")
    public RestTemplate kinopoiskRestTemplate(final KinopoiskProperties.Headers headers) {
        final RestTemplateBuilder builder = new RestTemplateBuilder();
        builder.defaultHeader(headers.getAuthHeaderName(), headers.getAuthHeaderValue());
        builder.setConnectTimeout(Duration.ofSeconds(30));
        builder.setReadTimeout(Duration.ofSeconds(30));
        return builder.build();
    }

//    @Bean
//    public ClientHttpRequestInterceptor getHeaderInterceptor(KinopoiskProperties kProp) {
//        return (request, body, execution) -> {
//            request.getHeaders().set(kProp.getAuthHeaderName(), kProp.getAuthHeaderValue());
//            request.getHeaders().setAccept(singletonList(APPLICATION_JSON));
//            return execution.execute(request, body);
//        };
//    }

}