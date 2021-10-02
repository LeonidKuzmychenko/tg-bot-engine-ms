package home.project.tgserialsserver.configuration.controllers;

import home.project.tgserialsserver.configuration.services.SubscribeSerialService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void subscribe(@RequestBody Object o) {
        //создать свою дто
        //o->chatId
    }

    @DeleteMapping
    public void unsubscribe(@RequestBody Object o) {
        //создать свою дто
        //o->chatId, serialId
    }
}

//Создать UserController (сохранить юзера)
//Создать SerialController (сохранить сериал)
