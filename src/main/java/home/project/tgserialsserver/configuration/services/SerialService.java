package home.project.tgserialsserver.configuration.services;

import home.project.tgserialsserver.configuration.model.Serial;
import home.project.tgserialsserver.configuration.repository.SerialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SerialService {
    @Autowired
    SerialRepository serialRepository;

    public Long findNameOfSerialById(String nameSerial){
        Serial byName = serialRepository.findByName(nameSerial);
        return byName.getId();
    }
}
