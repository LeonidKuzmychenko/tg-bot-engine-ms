package tg.project.engine.api.db.requests.user.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tg.project.engine.api.db.requests.serial.response.Serial;

import java.util.HashSet;
import java.util.Set;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class User {

    @JsonIgnore
    private Long id;

    @JsonIgnore
    private String chatId;

    private String command;

    @JsonIgnore
    @ToString.Exclude
    private Set<Serial> serials = new HashSet<>();

    public User(String chatId) {
        this.chatId = chatId;
        this.command = null;
    }

}