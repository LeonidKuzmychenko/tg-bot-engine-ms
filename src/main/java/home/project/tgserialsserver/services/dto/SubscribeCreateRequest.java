package home.project.tgserialsserver.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscribeCreateRequest {
    private String chatId;
    private String apiId;
}
