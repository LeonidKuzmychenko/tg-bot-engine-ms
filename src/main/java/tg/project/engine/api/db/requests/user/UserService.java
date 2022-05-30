package tg.project.engine.api.db.requests.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tg.project.engine.api.db.dtos.UserUpdateResponse;
import tg.project.engine.api.db.providers.DbUrlProvider;
import tg.project.engine.api.db.requests.user.response.User;
import tg.project.engine.provider.HeadersProvider;

import java.util.Set;

@Slf4j
@Service
public class UserService {

    private final RestTemplate restTemplate;
    private final DbUrlProvider dbUrlProvider;

    public UserService(RestTemplate restTemplate, DbUrlProvider dbUrlProvider) {
        this.restTemplate = restTemplate;
        this.dbUrlProvider = dbUrlProvider;
    }

    public User getAndCheckToExist(String chatId) {
        String url = dbUrlProvider.usersGet(chatId);
        return restTemplate.exchange(url, HttpMethod.GET, HeadersProvider.defaultEntity(), User.class).getBody();
    }

    public User updateUser(UserUpdateResponse userUpdateResponse) {
        HttpEntity<UserUpdateResponse> httpEntity = new HttpEntity<>(userUpdateResponse, new HttpHeaders());
        String url = dbUrlProvider.usersPut();
        return restTemplate.exchange(url, HttpMethod.PUT, httpEntity, User.class).getBody();
    }

    public Set<Long> getAllWhoSubscribeSerialByApiId(Long apiId) {
        String url = dbUrlProvider.getGetAllWhoSubscribeSerialByApiId(apiId);
        Long[] body = restTemplate.exchange(url, HttpMethod.GET, HeadersProvider.defaultEntity(), Long[].class).getBody();
        return Set.of(body);
    }
}