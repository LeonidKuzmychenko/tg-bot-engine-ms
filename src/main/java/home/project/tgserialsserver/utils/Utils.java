package home.project.tgserialsserver.utils;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Utils {

    public void sleep(int ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
