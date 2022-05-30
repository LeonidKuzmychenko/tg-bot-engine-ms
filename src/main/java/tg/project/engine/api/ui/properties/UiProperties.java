package tg.project.engine.api.ui.properties;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tg.project.engine.api.UrlContainer;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UiProperties {

    @Getter
    @Component
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Host implements UrlContainer {
        @Value("${ui.scheme}")
        private String scheme;

        @Value("${ui.host}")
        private String host;

        @Value("${ui.port}")
        private Integer port;
    }

    @Getter
    @Component
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Urls {

    }
}
