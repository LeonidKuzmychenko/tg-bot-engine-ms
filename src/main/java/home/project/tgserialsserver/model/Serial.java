package home.project.tgserialsserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "serials")
public class Serial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "apiId")
    private Long apiId;

    @ManyToMany(mappedBy = "serials")
    private Set<User> users = new HashSet<>();

    public Serial(Long apiId) {
        this.apiId = apiId;
    }

}