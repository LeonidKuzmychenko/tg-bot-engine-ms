package home.project.tgserialsserver.http.parent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;

public abstract class KinopoiskApi {

    @Autowired
    @Qualifier("ApiTokenEntity")
    protected HttpEntity<Void> httpEntity;

    @Value("${kinopoisk-api-unofficial.scheme}")
    protected String scheme;

    @Value("${kinopoisk-api-unofficial.host}")
    protected String host;

}
