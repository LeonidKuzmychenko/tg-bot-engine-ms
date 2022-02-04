package home.project.tgserialsserver.schedulers;

import home.project.tgserialsserver.services.PublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableScheduling
public class SubscribeScheduler {

    private final PublishService publishService;

    public SubscribeScheduler(PublishService publishService) {
        this.publishService = publishService;
    }


    //second, minute, hour, day, month, weekday
    @Scheduled(cron = "0 54 23 * * *")
    public void getUniqueSubscribedSerialsScheduled() {
        publishService.foo();
    }
}
