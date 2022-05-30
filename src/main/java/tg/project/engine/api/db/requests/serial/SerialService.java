package tg.project.engine.api.db.requests.serial;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tg.project.engine.api.db.providers.DbUrlProvider;
import tg.project.engine.provider.HeadersProvider;

import java.util.Set;

@Service
public class SerialService {

    private final RestTemplate restTemplate;
    private final DbUrlProvider dbUrlProvider;

    public SerialService(RestTemplate restTemplate, DbUrlProvider dbUrlProvider) {
        this.restTemplate = restTemplate;
        this.dbUrlProvider = dbUrlProvider;
    }

    public Set<Long> getUniqueSubscribedSerials() {
        String url = dbUrlProvider.getGetUniqueSubscribedSerials();
        Long[] body = restTemplate.exchange(url, HttpMethod.POST, HeadersProvider.defaultEntity(), Long[].class).getBody();
        return Set.of(body);
    }
}