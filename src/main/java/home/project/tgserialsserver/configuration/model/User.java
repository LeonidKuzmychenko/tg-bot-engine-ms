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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uiId")
    private Long uiId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_serials",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "serial_id")
    )
    private Set<Serial> serials;

    public User(Long uiId) {
        this.uiId = uiId;
    }

}
