package tg.project.engine.api.db.dtos;

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
