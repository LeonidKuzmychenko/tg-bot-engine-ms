package home.project.tgserialsserver.configuration.init;

import home.project.tgserialsserver.configuration.model.Serial;
import home.project.tgserialsserver.configuration.model.User;
import home.project.tgserialsserver.configuration.repository.SerialRepository;
import home.project.tgserialsserver.configuration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class InitDataBase {

    @Autowired
    private void init(SerialRepository serialRepository, UserRepository userRepository) {
        Set<Serial> serials_ = new HashSet<>();
        serials_.add(new Serial(178707L));
        serials_.add(new Serial(685246L));
        serials_.add(new Serial(404900L));
        serials_.add(new Serial(195384L));

        List<Serial> serials = serialRepository.saveAll(serials_);

        Set<User> users_ = new HashSet<>();
        users_.add(new User(1L));
        users_.add(new User(2L));
        users_.add(new User(3L));
        users_.add(new User(4L));

        List<User> users = userRepository.saveAll(users_);

        User user1 = users.get(0);
        Set<Serial> serials1 = new HashSet<>();
        serials1.add(serials.get(0));
        serials1.add(serials.get(1));
        serials1.add(serials.get(2));
        user1.setSerials(serials1);

        User user2 = users.get(1);
        Set<Serial> serials2 = new HashSet<>();
        serials2.add(serials.get(0));
        serials2.add(serials.get(1));
        user2.setSerials(serials2);

        User user3 = users.get(2);
        Set<Serial> serials3 = new HashSet<>();
        serials3.add(serials.get(0));
        user3.setSerials(serials3);

        userRepository.saveAll(users);

        Set<Long> uniqueSubscribedSerials = serialRepository.getUniqueSubscribedSerials();
        System.out.println("UniqueSubscribedSerials: " + uniqueSubscribedSerials);
        Set<Long> allUsersWhoSubscribeSerialByApiId = userRepository.getAllUsersWhoSubscribeSerialByApiId(178707L);
        System.out.println("AllUsersWhoSubscribeSerialByApiId: " + allUsersWhoSubscribeSerialByApiId);
    }
}
