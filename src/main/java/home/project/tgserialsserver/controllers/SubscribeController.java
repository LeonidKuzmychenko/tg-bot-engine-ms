package home.project.tgserialsserver.controllers;

import home.project.tgserialsserver.services.SubscribeSerialService;
import home.project.tgserialsserver.services.dto.SubscribeCreateRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/subscription")
public class SubscribeController {

    private final SubscribeSerialService subscribeSerialService;

    public SubscribeController(SubscribeSerialService subscribeSerialService) {
        this.subscribeSerialService = subscribeSerialService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void subscribe(@RequestBody SubscribeCreateRequest subscribeCreateRequest) {
        subscribeSerialService.subscribe(subscribeCreateRequest.getChatId(), subscribeCreateRequest.getApiId());
    }
}