package home.project.tgserialsserver.configuration.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "serials")
public class Serial {
    @Id
    @Getter
    @Setter
    private String id;

    @Setter
    @ManyToMany(mappedBy = "serialList")
    private Set<User> userSet;

    public Serial(String id) {
        this.id = id;
    }

    public Set<User> getUserSet() {
        if (userSet == null) {
            userSet = new HashSet<>();
        }
        return userSet;
    }
}
