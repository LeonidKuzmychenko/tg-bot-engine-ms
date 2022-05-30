package tg.project.engine.utils;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Sleeper {

    public void s(int s) {
        sleep(TimeUnit.SECONDS, (long) s);
    }

    public void ms(int ms) {
        sleep(TimeUnit.MILLISECONDS, (long) ms);
    }

    private void sleep(TimeUnit timeUnit, Long value) {
        try {
            timeUnit.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}