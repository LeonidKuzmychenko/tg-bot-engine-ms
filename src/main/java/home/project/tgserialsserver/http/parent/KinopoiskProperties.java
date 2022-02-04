package home.project.tgserialsserver.http.parent;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class KinopoiskProperties {

    @Value("${kinopoisk.scheme}")
    private String sheme;

    @Value("${kinopoisk.host}")
    private String host;

    @Value("${kinopoisk.auth.header.name}")
    private String authHeaderName;

    @Value("${kinopoisk.auth.header.value}")
    private String authHeaderValue;

    @Value("${kinopoisk.url.search-by-text}")
    private String urlSearchByText;

    @Value("${kinopoisk.url.serial-by-id}")
    private String urlSerialById;
}