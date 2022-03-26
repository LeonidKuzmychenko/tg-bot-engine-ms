package home.project.tgserialsserver.repository;

import home.project.tgserialsserver.model.Serial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface SerialRepository extends JpaRepository<Serial, Long> {

    @Query(value = "select distinct s.api_id from serials s join users_serials us on us.serial_id = s.id",
            nativeQuery = true)
    Set<Long> getUniqueSubscribedSerials();

    @Query(value = "select * from serials s where s.api_id = :apiId", nativeQuery = true)
    Optional<Serial> findByApiId(@Param("apiId") String apiId);
}