package home.project.tgserialsserver.configuration.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    private String id;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_serials",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "serial_id")
    )
    private Set<Serial> serials;

    public User(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" + "id='" + id + "'}";
    }
}
