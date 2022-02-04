package home.project.tgserialsserver.configuration.services;

import home.project.tgserialsserver.configuration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    public User saveUser(String chatId) {
//        return userRepository.findById(chatId).orElseGet(() -> userRepository.save(new User(chatId)));
//    }
}
