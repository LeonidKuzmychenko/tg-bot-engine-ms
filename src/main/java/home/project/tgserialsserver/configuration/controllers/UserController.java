package home.project.tgserialsserver.configuration.controllers;

import home.project.tgserialsserver.configuration.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

//    @PostMapping
//    public ResponseEntity<Void> register(@RequestBody RegistrationUserDto registrationUserDto) {
//        userService.saveUser(registrationUserDto.getChatId());
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
