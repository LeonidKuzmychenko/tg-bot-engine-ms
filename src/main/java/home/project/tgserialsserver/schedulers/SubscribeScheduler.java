package home.project.tgserialsserver.schedulers;

import home.project.tgserialsserver.services.SerialService;
import home.project.tgserialsserver.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableScheduling
public class SubscribeScheduler {

    private final UserService userService;
    private final SerialService serialService;

    public SubscribeScheduler(UserService userService, SerialService serialService) {
        this.userService = userService;
        this.serialService = serialService;
    }

    //second, minute, hour, day, month, weekday
    @Scheduled(cron = "*/20 * * * * *")
    public void getUniqueSubscribedSerialsScheduled() {
//        Set<Long> uniqueSubscribedSerials = serialService.getUniqueSubscribedSerials();
//        log.info("UniqueSubscribedSerials: {}", uniqueSubscribedSerials);
    }
}
