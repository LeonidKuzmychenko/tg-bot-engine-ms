package home.project.tgserialsserver.configuration.repository;

import home.project.tgserialsserver.configuration.model.Serial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SerialRepository extends JpaRepository<Serial, Long> {

    @Query(value = "select distinct s.api_id from serials s join users_serials us on us.serial_id = s.id",
            nativeQuery = true)
    Set<Long> getUniqueSubscribedSerials();
}
