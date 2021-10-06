package home.project.tgserialsserver.configuration.dto;

import home.project.tgserialsserver.configuration.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SerialDto {
    private String id;
    private Set<User> userSet;
}
