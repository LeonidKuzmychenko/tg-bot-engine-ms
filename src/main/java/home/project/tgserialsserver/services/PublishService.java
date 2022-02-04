package home.project.tgserialsserver.services;

import home.project.tgserialsserver.services.dto.FormattedEpisode;
import home.project.tgserialsserver.services.dto.SerialsWhatReleaseToday;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PublishService {

    private final String MESSAGE_SCHEMA = "%s\nСегодня выходит:\n%s";

    private final SerialService serialService;
    private final UserService userService;

    public PublishService(SerialService serialService, UserService userService) {
        this.serialService = serialService;
        this.userService = userService;
    }

    /**
     * Формирование и отправкаа сообщений о выходе серий сериала всем подписчикам
     */
    public void foo() {
        serialService.getSerialsWhatReleaseToday().forEach(episodes -> {
            Set<Long> subscribers = userService.getAllUsersWhoSubscribeSerialByApiId(episodes.getSerialId());
            String message = getMessage(episodes);
            sendMessage(subscribers, message);
        });
    }

    /**
     * Отправка сообщения в ТГ бот
     */
    public void sendMessage(Set<Long> subscribers, String message) {
        //TODO
        subscribers.forEach(subscriber -> System.out.println("\n" + message + "\nto user " + subscriber));
    }

    /**
     * Формировка текст сообщения для ТГ бота
     */
    private String getMessage(SerialsWhatReleaseToday releasesEpisodes) {
        String episodesText = releasesEpisodes.getReleasesEpisode().stream()
                .map(FormattedEpisode::newInstance)
                .map(FormattedEpisode::format)
                .collect(Collectors.joining("\n"));
        return String.format(MESSAGE_SCHEMA, releasesEpisodes.getSerialName(), episodesText);
    }

}
