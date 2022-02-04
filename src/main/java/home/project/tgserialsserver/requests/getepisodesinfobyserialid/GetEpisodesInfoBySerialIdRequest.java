package home.project.tgserialsserver.requests.getepisodesinfobyserialid;

import home.project.tgserialsserver.provider.KinopoiskUrlProvider;
import home.project.tgserialsserver.requests.AbstractKinopoiskRequest;
import home.project.tgserialsserver.requests.getepisodesinfobyserialid.response.GetEpisodesInfoBySerialIdResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.springframework.http.HttpMethod.GET;

@Component
public class GetEpisodesInfoBySerialIdRequest extends AbstractKinopoiskRequest {

    public GetEpisodesInfoBySerialIdRequest(RestTemplate restTemplate, KinopoiskUrlProvider urlProvider) {
        super(restTemplate, urlProvider);
    }

    public Optional<GetEpisodesInfoBySerialIdResponseDto> execute(Long serialId) {
        String url = urlProvider.episodesInfoBySerialId(serialId);
        ResponseEntity<GetEpisodesInfoBySerialIdResponseDto> response =
                restTemplate.exchange(url, GET, defaultEntity(), GetEpisodesInfoBySerialIdResponseDto.class);
        GetEpisodesInfoBySerialIdResponseDto body = response.getBody();
        return Optional.ofNullable(body);
    }
}