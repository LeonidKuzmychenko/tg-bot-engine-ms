package home.project.tgserialsserver.schedulers;

import home.project.tgserialsserver.services.CronService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableScheduling
public class SubscribeScheduler {

    private final CronService cronService;

    public SubscribeScheduler(CronService cronService) {
        this.cronService = cronService;
    }

    //second, minute, hour, day, month, weekday
    @Scheduled(cron = "00 51 * * * *")
    public void getUniqueSubscribedSerialsScheduled() {
        System.out.println("start");
        cronService.publishAll();
        System.out.println("end");
    }
}
