package home.project.tgserialsserver.configuration.services;

import home.project.tgserialsserver.configuration.model.Serial;
import home.project.tgserialsserver.configuration.model.User;
import home.project.tgserialsserver.configuration.repository.SerialRepository;
import home.project.tgserialsserver.configuration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscribeSerialService {

    @Autowired
    private SerialRepository serialRepository;

    @Autowired
    private UserRepository userRepository;

    //create controller
    public void subUserToSerial(User user, Serial serial) {
        //использовать кеш из метода "findSerialByName"
        //записать в бд подписку
        user.getSerialList().add(serial);
        serial.getUserSet().add(user);

        userRepository.save(user);
//        serialRepository.save(serial); TODO
    }
}
