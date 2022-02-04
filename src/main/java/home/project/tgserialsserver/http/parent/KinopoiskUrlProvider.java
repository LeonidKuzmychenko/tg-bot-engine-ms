package home.project.tgserialsserver.http.parent;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class KinopoiskUrlProvider {

    private final KinopoiskProperties prop;

    public KinopoiskUrlProvider(KinopoiskProperties prop) {
        this.prop = prop;
    }

    public String searchByText(String text) {
        return getUriComponentsBuilder()
                .path(prop.getUrlSearchByText())
                .buildAndExpand(text)
                .toString();
    }

    public String serialById(String id) {
        return getUriComponentsBuilder()
                .path(prop.getUrlSerialById())
                .buildAndExpand(id)
                .toString();
    }

    private UriComponentsBuilder getUriComponentsBuilder() {
        return UriComponentsBuilder.newInstance().scheme(prop.getSheme()).host(prop.getHost());
    }

}