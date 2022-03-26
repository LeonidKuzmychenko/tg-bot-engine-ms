package home.project.tgserialsserver.services;

import home.project.tgserialsserver.model.User;
import home.project.tgserialsserver.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User save(User user) {
        return repository.save(user);
    }

    public User getAndCheckToExist(String chatId) {
        log.info("Проверка юзера {} на существование", chatId);
        return repository.findByChatId(chatId).orElseGet(() -> repository.save(new User(chatId)));
    }

    /**
     * Взять всех пользователей, кто подписан на указанный сериал
     */
    public Set<Long> getAllWhoSubscribeSerialByApiId(Long apiId) {
        return repository.getAllUsersWhoSubscribeSerialByApiId(apiId);
    }
}