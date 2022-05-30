package tg.project.engine.api.scheduler.providers;

import org.springframework.stereotype.Component;
import tg.project.engine.api.AbstractUrlProvider;
import tg.project.engine.api.scheduler.properties.SchedulerProperties;

@Component
public class SchedulerUrlProvider extends AbstractUrlProvider {

    protected SchedulerUrlProvider(SchedulerProperties.Host urlContainer) {
        super(urlContainer);
    }
}
