package home.project.tgserialsserver.http.parent;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestTemplateKinopoiskConfiguration {

    @Bean("kinopoiskRestTemplate")
    public RestTemplate kinopoiskRestTemplate(final KinopoiskProperties kProp) {
        final RestTemplateBuilder builder = new RestTemplateBuilder();
        builder.defaultHeader(kProp.getAuthHeaderName(), kProp.getAuthHeaderValue());
        builder.setConnectTimeout(Duration.ofSeconds(30));
        builder.setReadTimeout(Duration.ofSeconds(30));
        return builder.build();
    }

//    @Bean("kinopoiskUriBuilder")
//    @Scope(value = SCOPE_PROTOTYPE)
//    public UriComponentsBuilder kinopoiskUriBuilder(final KinopoiskProperties kProp) {
//        return UriComponentsBuilder.newInstance().scheme(kProp.getSheme()).host(kProp.getHost());
//    }

//    @Bean
//    public ClientHttpRequestInterceptor getHeaderInterceptor(KinopoiskProperties kProp) {
//        return (request, body, execution) -> {
//            request.getHeaders().set(kProp.getAuthHeaderName(), kProp.getAuthHeaderValue());
//            request.getHeaders().setAccept(singletonList(APPLICATION_JSON));
//            return execution.execute(request, body);
//        };
//    }

}