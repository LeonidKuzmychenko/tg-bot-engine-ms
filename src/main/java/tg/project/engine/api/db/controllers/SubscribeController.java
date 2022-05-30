package tg.project.engine.api.db.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tg.project.engine.api.db.dtos.SubscribeCreateRequest;
import tg.project.engine.api.db.requests.subscription.SubscribeSerialService;

@RestController
@RequestMapping("/v1/subscriptions")
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