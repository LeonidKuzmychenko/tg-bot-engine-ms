package tg.project.engine.api.kinopoisk.requests.getepisodesinfobyserialid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tg.project.engine.api.kinopoisk.providers.KinopoiskUrlProvider;
import tg.project.engine.api.kinopoisk.requests.getepisodesinfobyserialid.response.SerialsWhatReleaseTodayDto;

import static org.springframework.http.HttpMethod.GET;
import static tg.project.engine.provider.HeadersProvider.defaultEntity;

@Component
public class GetEpisodesInfoBySerialIdRequest {


    private final RestTemplate restTemplate;
    private final KinopoiskUrlProvider urlProvider;

    public GetEpisodesInfoBySerialIdRequest(RestTemplate restTemplate, KinopoiskUrlProvider urlProvider) {
        this.restTemplate = restTemplate;
        this.urlProvider = urlProvider;
    }

    public SerialsWhatReleaseTodayDto get(Long serialId) {
        String url = urlProvider.episodesInfoBySerialId(serialId);
        System.out.println("URL: " + url);
        System.out.println("ENTITY: " + defaultEntity());
        ResponseEntity<SerialsWhatReleaseTodayDto> response =
                restTemplate.exchange(url, GET, defaultEntity(), SerialsWhatReleaseTodayDto.class);
        return response.getBody();
    }
}