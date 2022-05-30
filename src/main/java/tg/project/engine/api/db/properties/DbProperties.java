package tg.project.engine.api.db.properties;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tg.project.engine.api.UrlContainer;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DbProperties {

    @Getter
    @Component
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Host implements UrlContainer {
        @Value("${db.scheme}")
        private String scheme;

        @Value("${db.host}")
        private String host;

        @Value("${db.port}")
        private Integer port;
    }

    @Getter
    @Component
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Urls {
        @Value("${db.url.users-get}")
        private String usersGet;

        @Value("${db.url.users-put}")
        private String usersPut;

        @Value("${db.url.subscriptions}")
        private String subscriptions;

        @Value("${db.url.get-unique-subscribed-serials}")
        private String getUniqueSubscribedSerials;

        @Value("${db.url.get-all-subscribe-serial-by-api-id}")
        private String getAllWhoSubscribeSerialByApiId;
    }
}