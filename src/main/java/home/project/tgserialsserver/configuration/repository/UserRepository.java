package home.project.tgserialsserver.configuration.repository;

import home.project.tgserialsserver.configuration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select u.ui_id from users u " +
            "join users_serials us on us.user_id = u.id " +
            "join serials s on us.serial_id = s.id " +
            "where api_id = :apiId", nativeQuery = true)
    Set<Long> getAllUsersWhoSubscribeSerialByApiId(@Param("apiId") Long apiId);
}
