package home.project.tgserialsserver.properties;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class KinopoiskProperties {

    @Getter
    @Component
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Host {
        @Value("${kinopoisk.scheme}")
        private String sheme;

        @Value("${kinopoisk.host}")
        private String host;
    }

    @Getter
    @Component
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Headers {
        @Value("${kinopoisk.auth.header.name}")
        private String authHeaderName;

        @Value("${kinopoisk.auth.header.value}")
        private String authHeaderValue;
    }

    @Getter
    @Component
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Urls {
        @Value("${kinopoisk.url.search-serial-by-serial-name}")
        private String urlSearchSerialBySerialName;

        @Value("${kinopoisk.url.episodes-info-by-serial-id}")
        private String urlEpisodesInfoBySerialId;

        @Value("${kinopoisk.url.serial-info-by-serial-id}")
        private String urlSerialInfoBySerialId;
    }

}