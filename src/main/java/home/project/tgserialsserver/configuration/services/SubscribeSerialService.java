package home.project.tgserialsserver.configuration.services;

import com.google.common.cache.Cache;
import home.project.tgserialsserver.configuration.repository.SerialRepository;
import home.project.tgserialsserver.configuration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SubscribeSerialService {

    @Autowired
    private SerialRepository serialRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Qualifier("SearchSerialCache")
    private Cache<String, String> cache;

//    public void subUserToSerial(String chatId) {
//        String serialId = cache.getIfPresent(chatId);
//        User user = userRepository.findById(chatId).get();
//        Serial serial = serialRepository.findById(serialId).orElseGet(() -> serialRepository.save(new Serial(serialId)));
//        user.getSerials().add(serial);
//        serial.getUsers().add(user);
//        userRepository.save(user);
//    }
}
