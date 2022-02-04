package home.project.tgserialsserver.requests.getserialinfobyserialid;

import home.project.tgserialsserver.provider.KinopoiskUrlProvider;
import home.project.tgserialsserver.requests.AbstractKinopoiskRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GetSerialInfoBySerialIdRequest extends AbstractKinopoiskRequest {

    public GetSerialInfoBySerialIdRequest(RestTemplate restTemplate, KinopoiskUrlProvider urlProvider) {
        super(restTemplate, urlProvider);
    }

    public void execute() {

    }
}
