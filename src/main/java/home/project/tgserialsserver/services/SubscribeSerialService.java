package home.project.tgserialsserver.services;

import home.project.tgserialsserver.model.Serial;
import home.project.tgserialsserver.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SubscribeSerialService {

    private final UserService userService;
    private final SerialService serialService;

    public SubscribeSerialService(UserService userService, SerialService serialService) {
        this.userService = userService;
        this.serialService = serialService;
    }

    public void subscribe(String chatId, String serialId) {
        log.info("subscribe {} to {}", chatId, serialId);
        User user = userService.getAndCheckToExist(chatId);
        Serial serial = serialService.getSerialByApiIdAndCheckForExist(serialId);
        user.getSerials().add(serial);
        serial.getUsers().add(user);
        userService.save(user);
    }

}