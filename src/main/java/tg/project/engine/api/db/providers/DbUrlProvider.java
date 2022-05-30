package tg.project.engine.api.db.providers;

import org.springframework.stereotype.Component;
import tg.project.engine.api.AbstractUrlProvider;
import tg.project.engine.api.db.properties.DbProperties;

@Component
public class DbUrlProvider extends AbstractUrlProvider {

    private final DbProperties.Urls urls;

    protected DbUrlProvider(DbProperties.Host urlContainer, DbProperties.Urls urls) {
        super(urlContainer);
        this.urls = urls;
    }

    public String usersGet(String chatId) {
        return getUriComponentsBuilder()
                .path(urls.getUsersGet())
                .buildAndExpand(chatId)
                .toString();
    }

    public String usersPut() {
        return getUriComponentsBuilder()
                .path(urls.getUsersPut())
                .build()
                .toString();
    }

    public String subscriptions() {
        return getUriComponentsBuilder()
                .path(urls.getSubscriptions())
                .build()
                .toString();
    }

    public String getGetAllWhoSubscribeSerialByApiId(Long apiId) {
        return getUriComponentsBuilder()
                .path(urls.getGetAllWhoSubscribeSerialByApiId())
                .buildAndExpand(apiId)
                .toString();
    }

    public String getGetUniqueSubscribedSerials() {
        return getUriComponentsBuilder()
                .path(urls.getGetUniqueSubscribedSerials())
                .build()
                .toString();
    }
}