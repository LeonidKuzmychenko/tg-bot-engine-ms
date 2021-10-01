package home.project.tgserialsserver.configuration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    private Long Id;
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="users_serials",
        joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="serial_id")
    )
    private List<Serial> serialList;


}
