package tg.project.engine.api.db.requests.serial.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tg.project.engine.api.db.requests.user.response.User;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Serial {

    private Long id;
    private String apiId;
    private Set<User> users = new HashSet<>();

    public Serial(String apiId) {
        this.apiId = apiId;
    }

}