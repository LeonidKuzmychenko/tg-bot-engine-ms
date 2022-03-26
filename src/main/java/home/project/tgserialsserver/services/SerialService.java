package home.project.tgserialsserver.services;

import home.project.tgserialsserver.model.Serial;
import home.project.tgserialsserver.repository.SerialRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SerialService {

    private final SerialRepository repository;

    public SerialService(SerialRepository repository) {
        this.repository = repository;
    }

    public Serial getSerialByApiIdAndCheckForExist(String apiId) {
        return repository.findByApiId(apiId).orElseGet(() -> repository.save(new Serial(apiId)));
    }

    public Set<Long> getUniqueSubscribedSerials() {
        return repository.getUniqueSubscribedSerials();
    }
}