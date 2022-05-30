package tg.project.engine.api.ui.providers;

import org.springframework.stereotype.Component;
import tg.project.engine.api.AbstractUrlProvider;
import tg.project.engine.api.ui.properties.UiProperties;

@Component
public class UiUrlProvider extends AbstractUrlProvider {
    protected UiUrlProvider(UiProperties.Host urlContainer) {
        super(urlContainer);
    }
}
