package home.project.tgserialsserver.requests.getserialinfobyserialid;

import home.project.tgserialsserver.provider.KinopoiskUrlProvider;
import home.project.tgserialsserver.requests.AbstractKinopoiskRequest;
import home.project.tgserialsserver.requests.getserialinfobyserialid.response.GetSerialInfoBySerialIdResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.springframework.http.HttpMethod.GET;

@Component
public class GetSerialInfoBySerialIdRequest extends AbstractKinopoiskRequest {

    public GetSerialInfoBySerialIdRequest(RestTemplate restTemplate, KinopoiskUrlProvider urlProvider) {
        super(restTemplate, urlProvider);
    }

    public Optional<GetSerialInfoBySerialIdResponseDto> execute(Long serialId) {
        String url = urlProvider.serialInfoBySerialId(serialId);
        ResponseEntity<GetSerialInfoBySerialIdResponseDto> response =
                restTemplate.exchange(url, GET, defaultEntity(), GetSerialInfoBySerialIdResponseDto.class);
        return Optional.ofNullable(response.getBody());
    }
}
