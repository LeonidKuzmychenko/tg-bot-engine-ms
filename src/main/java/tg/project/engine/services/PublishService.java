package tg.project.engine.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tg.project.engine.dtos.MessageDto;

import java.util.Set;

@Slf4j
@Service
public class PublishService {

    /**
     * Отправка сообщения в ТГ бот
     */
    public void sendMessage(MessageDto messageDto) {
        //TODO
        Set<Long> subscribers = messageDto.getSubscribers();
        subscribers.forEach(subscriber -> System.out.println("\n" + messageDto.getMessage() + "\nto user " + subscriber));
    }
}