package home.project.tgserialsserver.configuration.controllers;

import home.project.tgserialsserver.configuration.model.Serial;
import home.project.tgserialsserver.configuration.model.User;
import home.project.tgserialsserver.configuration.services.SubscribeSerialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private SubscribeSerialService subscribeSerialService;
    @Autowired
    public UserController(SubscribeSerialService subscribeSerialService) {
        this.subscribeSerialService = subscribeSerialService;
    }

    @PostMapping("/add-user-and-serial")
    public void addUserAndSerial(User user, Serial serial) {
        subscribeSerialService.subUserToSerial(user,serial);
    }
}
