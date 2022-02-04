package home.project.tgserialsserver.services;

import home.project.tgserialsserver.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Set<Long> foo(Long apiId) {
        return repository.getAllUsersWhoSubscribeSerialByApiId(apiId);
    }
}