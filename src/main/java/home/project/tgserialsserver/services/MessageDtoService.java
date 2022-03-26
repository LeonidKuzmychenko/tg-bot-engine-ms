package home.project.tgserialsserver.services;

import home.project.tgserialsserver.services.dto.MessageDto;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MessageDtoService {

    private final MessageService messageService;
    private final SerialsWhatReleaseTodayService serialsWhatReleaseTodayService;
    private final UserService userService;

    public MessageDtoService(MessageService messageService, SerialsWhatReleaseTodayService serialsWhatReleaseTodayService, UserService userService) {
        this.messageService = messageService;
        this.serialsWhatReleaseTodayService = serialsWhatReleaseTodayService;
        this.userService = userService;
    }

    /**
     * Формирование сообщений о выходе серий сериала всем подписчикам
     */
    public Set<MessageDto> createMessageDto() {
        return serialsWhatReleaseTodayService.getSerialsWhatReleaseToday()
                .stream()
                .map(episodes -> {
                    Set<Long> subscribers = userService.getAllWhoSubscribeSerialByApiId(episodes.getSerialId());
                    String message = messageService.getMessageFromSerialsWhatReleaseToday(episodes);
                    return new MessageDto(message, subscribers);
                })
                .collect(Collectors.toSet());
    }

}
