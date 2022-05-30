package tg.project.engine.api.kinopoisk.providers;

import org.springframework.stereotype.Component;
import tg.project.engine.api.AbstractUrlProvider;
import tg.project.engine.api.kinopoisk.properties.KinopoiskProperties;

@Component
public class KinopoiskUrlProvider extends AbstractUrlProvider {

    private final KinopoiskProperties.Urls urls;

    protected KinopoiskUrlProvider(KinopoiskProperties.Host urlContainer, KinopoiskProperties.Urls urls) {
        super(urlContainer);
        this.urls = urls;
    }


    public String searchSerialBySerialName(String text) {
        return getUriComponentsBuilder()
                .path(urls.getUrlSearchSerialBySerialName())
                .buildAndExpand(text)
                .toString();
    }

    public String episodesInfoBySerialId(Long serialId) {
        return getUriComponentsBuilder()
                .path(urls.getUrlEpisodesInfoBySerialId())
                .buildAndExpand(serialId)
                .toString();
    }
}