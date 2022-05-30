package tg.project.engine.schedulers.cron;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import static java.lang.Boolean.TRUE;
import static java.lang.Boolean.parseBoolean;
import static java.lang.System.getenv;
import static java.util.Optional.ofNullable;

@Aspect
@Component
public class CronAspect {

    private static final String CRON_ENABLED = "CRON_ENABLED";

    @Around("@annotation(org.springframework.scheduling.annotation.Scheduled)")
    public Object cronEnabled(ProceedingJoinPoint pjp) throws Throwable {
        String value = getenv(CRON_ENABLED);
        String nullableValue = ofNullable(value).orElse(TRUE.toString());
        return parseBoolean(nullableValue) ? pjp.proceed() : pjp;
    }
}