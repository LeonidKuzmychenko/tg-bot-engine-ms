package home.project.tgserialsserver.configuration.controllers;

import home.project.tgserialsserver.configuration.dto.SubscribeDto;
import home.project.tgserialsserver.configuration.services.SubscribeSerialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscription")
public class SubscribeController {

    @Autowired
    private SubscribeSerialService subscribeSerialService;

    @GetMapping
    public void get(@RequestParam("id") String chatId) {

    }

    @PostMapping
    public ResponseEntity<Void> subscribe(@RequestBody SubscribeDto subscribeDto) {
        subscribeSerialService.subUserToSerial(subscribeDto.getChatId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public void unsubscribe(@RequestBody Object o) {
        //создать свою дто
        //o->chatId, serialId
    }
}

