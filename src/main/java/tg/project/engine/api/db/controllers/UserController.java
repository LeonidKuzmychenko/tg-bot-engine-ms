package tg.project.engine.api.db.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tg.project.engine.api.db.dtos.UserUpdateResponse;
import tg.project.engine.api.db.requests.user.UserService;
import tg.project.engine.api.db.requests.user.response.User;

import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User getAndCheckToExist(@RequestParam("chatId") String chatId) {
        return userService.getAndCheckToExist(chatId);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@RequestBody UserUpdateResponse userUpdateResponse) {
        return userService.updateUser(userUpdateResponse);
    }

    @GetMapping(value = "/getAllWhoSubscribeSerialByApiId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Long> getAllWhoSubscribeSerialByApiId(Long apiId) {
        return userService.getAllWhoSubscribeSerialByApiId(apiId);
    }
}