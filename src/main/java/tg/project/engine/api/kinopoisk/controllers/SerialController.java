package tg.project.engine.api.kinopoisk.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tg.project.engine.api.kinopoisk.requests.searchserialbyserialname.SearchSerialBySerialNameRequest;
import tg.project.engine.api.kinopoisk.requests.searchserialbyserialname.response.SearchByNameResponse;

@RestController
@RequestMapping("/v1/serials")
public class SerialController {

    private final SearchSerialBySerialNameRequest searchSerialByName;

    public SerialController(SearchSerialBySerialNameRequest searchSerialByName) {
        this.searchSerialByName = searchSerialByName;
    }

    @GetMapping
    public SearchByNameResponse getSerialFromName(@RequestParam("name") String name) {
        return searchSerialByName.get(name);
    }

}
