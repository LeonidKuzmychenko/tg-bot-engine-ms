package home.project.tgserialsserver.repository;

import home.project.tgserialsserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select u.chat_id from users u " +
            "join users_serials us on us.user_id = u.id " +
            "join serials s on us.serial_id = s.id " +
            "where us.serialId = :serialId", nativeQuery = true)
    Set<Long> getAllUsersWhoSubscribeSerialByApiId(@Param("serialId") Long serialId);

    @Query(value = "select * from users u where u.chat_id = :chatId", nativeQuery = true)
    Optional<User> findByChatId(@Param("chatId") String chatId);
}