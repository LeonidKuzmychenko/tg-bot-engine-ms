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
public class Item {

    @JsonProperty("number")
    private Integer number;

    @JsonProperty("episodes")
    private List<Episode> episodes = new ArrayList<>();
}