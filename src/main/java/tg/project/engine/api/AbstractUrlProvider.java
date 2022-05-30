package tg.project.engine.api;

import org.springframework.web.util.UriComponentsBuilder;

public abstract class AbstractUrlProvider {

    private final UrlContainer urlContainer;

    protected AbstractUrlProvider(UrlContainer urlContainer) {
        this.urlContainer = urlContainer;
    }

    protected UriComponentsBuilder getUriComponentsBuilder() {
        return UriComponentsBuilder.newInstance()
                .scheme(urlContainer.getScheme())
                .host(urlContainer.getHost())
                .port(urlContainer.getPort());
    }
}