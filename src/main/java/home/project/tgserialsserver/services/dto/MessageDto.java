package home.project.tgserialsserver.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {

    private String message;
    private Set<Long> subscribers = new HashSet<>();
}