package tg.project.engine.api.db.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tg.project.engine.api.db.requests.serial.SerialService;

import java.util.Set;

@RestController
@RequestMapping("/v1/serials")
public class SerialsController {

    private final SerialService serialService;

    public SerialsController(SerialService serialService) {
        this.serialService = serialService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Long> getUniqueSubscribedSerials(){
        return serialService.getUniqueSubscribedSerials();
    }
}