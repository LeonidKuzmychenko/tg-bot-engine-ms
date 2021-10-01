package home.project.tgserialsserver.configuration.repository;

import home.project.tgserialsserver.configuration.model.Serial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerialRepository extends CrudRepository<Serial,Long> {
    Serial findByName (String name);


}
