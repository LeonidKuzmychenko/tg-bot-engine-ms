package home.project.tgserialsserver.configuration.services;

import home.project.tgserialsserver.configuration.model.Serial;
import home.project.tgserialsserver.configuration.repository.SerialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerialService {

    @Autowired
    private SerialRepository serialRepository;

    //create controller
    public void findSerialByName(String chatId, String searchName) {
        //TODO HTTP request (@Component) only first
        //create DTO
        //fullname
        //poster(http)

        //надо закешировать найденный результат Cache<String(chatId),String(serialId)>
    }

    //create controller
    public List<Serial> findSubscribeSerialsByChatId(String chatId) {
        //TODO HTTP request (@Component)
        //create DTO
        //fullname
        //poster(http)
        return null;
    }


}
