package tg.project.engine.services;

import org.springframework.stereotype.Service;

@Service
public class CronService {

    private final PublishService publishService;
    private final MessageDtoService messageDtoService;

    public CronService(PublishService publishService, MessageDtoService messageDtoService) {
        this.publishService = publishService;
        this.messageDtoService = messageDtoService;
    }

    public void publishAll() {
        messageDtoService.createMessageDto().forEach(publishService::sendMessage);
    }
}