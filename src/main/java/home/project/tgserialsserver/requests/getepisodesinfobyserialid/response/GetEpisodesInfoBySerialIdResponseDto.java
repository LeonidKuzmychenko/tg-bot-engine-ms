package home.project.tgserialsserver.requests.getepisodesinfobyserialid.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEpisodesInfoBySerialIdResponseDto {

    @JsonProperty("total")
    private Integer total;

    @JsonProperty("items")
    private List<Item> items = new ArrayList<>();
}