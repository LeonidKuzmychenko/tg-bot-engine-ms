package tg.project.engine.api.kinopoisk.properties;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tg.project.engine.api.UrlContainer;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class KinopoiskProperties {

    @Getter
    @Component
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Host implements UrlContainer {
        @Value("${kinopoisk.scheme}")
        private String scheme;

        @Value("${kinopoisk.host}")
        private String host;

        @Value("${kinopoisk.port}")
        private Integer port;
    }

    @Getter
    @Component
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Urls {
        @Value("${kinopoisk.url.search-serial-by-serial-name}")
        private String urlSearchSerialBySerialName;

        @Value("${kinopoisk.url.episodes-info-by-serial-id}")
        private String urlEpisodesInfoBySerialId;
    }

}