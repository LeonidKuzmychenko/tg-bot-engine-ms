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
    SerialRepository serialRepository;
    @Autowired
    UserRepository userRepository;
    public void subUserToSerial(User user, Serial serial){
    userRepository.save(user);
    serialRepository.save(serial);
    }
}
