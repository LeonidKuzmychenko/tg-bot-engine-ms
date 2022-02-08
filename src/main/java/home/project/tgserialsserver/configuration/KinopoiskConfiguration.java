package home.project.tgserialsserver.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class KinopoiskConfiguration {

    @Bean("kinopoiskRestTemplate")
    public RestTemplate kinopoiskRestTemplate() {
        final RestTemplateBuilder builder = new RestTemplateBuilder();
        builder.setConnectTimeout(Duration.ofSeconds(30));
        builder.setReadTimeout(Duration.ofSeconds(30));
        return builder.build();
    }

}