package home.project.tgserialsserver.provider;

import home.project.tgserialsserver.properties.KinopoiskProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class KinopoiskUrlProvider {

    private final KinopoiskProperties.Host host;
    private final KinopoiskProperties.Urls urls;

    public KinopoiskUrlProvider(KinopoiskProperties.Host host, KinopoiskProperties.Urls urls) {
        this.host = host;
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

    public String serialInfoBySerialId(Long serialId) {
        return getUriComponentsBuilder()
                .path(urls.getUrlSerialInfoBySerialId())
                .buildAndExpand(serialId)
                .toString();
    }

    private UriComponentsBuilder getUriComponentsBuilder() {
        return UriComponentsBuilder.newInstance().scheme(host.getSheme()).host(host.getHost());
    }
}