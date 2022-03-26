package home.project.tgserialsserver.controllers;

import home.project.tgserialsserver.model.User;
import home.project.tgserialsserver.services.UserService;
import home.project.tgserialsserver.services.dto.UserUpdateResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User getByChatId(@RequestParam("chatId") String chatId) {
        User user = userService.getAndCheckToExist(chatId);
        log.info("Answer GET /v1/user: {}", user);
        return user;
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@RequestBody UserUpdateResponse userUpdateResponse) {
        User user = userService.getAndCheckToExist(userUpdateResponse.getChatId());
        user.setCommand(userUpdateResponse.getCommand());
        log.info("Answer PUT /v1/user: {}", user);
        return userService.save(user);
    }


}