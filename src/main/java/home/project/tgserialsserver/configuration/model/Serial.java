package home.project.tgserialsserver.configuration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "serials")
public class Serial {
    @Id
    private Long Id;

    @ManyToMany(mappedBy = "serials")
    private Set<User> userSet;
}
