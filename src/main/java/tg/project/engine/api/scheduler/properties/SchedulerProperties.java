package tg.project.engine.api.scheduler.properties;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tg.project.engine.api.UrlContainer;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SchedulerProperties {
    @Getter
    @Component
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Host implements UrlContainer {
        @Value("${scheduler.scheme}")
        private String scheme;

        @Value("${scheduler.host}")
        private String host;

        @Value("${scheduler.port}")
        private Integer port;
    }

    @Getter
    @Component
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Urls {

    }
}
