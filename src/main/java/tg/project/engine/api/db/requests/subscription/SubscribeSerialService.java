package tg.project.engine.api.db.requests.subscription;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tg.project.engine.api.db.dtos.SubscribeCreateRequest;
import tg.project.engine.api.db.providers.DbUrlProvider;

@Slf4j
@Service
public class SubscribeSerialService {

    private final RestTemplate restTemplate;
    private final DbUrlProvider dbUrlProvider;

    public SubscribeSerialService(RestTemplate restTemplate, DbUrlProvider dbUrlProvider) {
        this.restTemplate = restTemplate;
        this.dbUrlProvider = dbUrlProvider;
    }

    public void subscribe(String chatId, String serialId) {
        SubscribeCreateRequest request = new SubscribeCreateRequest(chatId, serialId);
        HttpEntity<SubscribeCreateRequest> httpEntity = new HttpEntity<>(request, new HttpHeaders());
        String url = dbUrlProvider.subscriptions();
        restTemplate.exchange(url, HttpMethod.POST, httpEntity, Void.class);
    }

}