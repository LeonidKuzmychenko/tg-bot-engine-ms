package home.project.tgserialsserver.controllers;

import home.project.tgserialsserver.requests.searchserialbyserialname.SearchSerialBySerialNameRequest;
import home.project.tgserialsserver.requests.searchserialbyserialname.dto.SearchByNameDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/serial")
public class SerialController {

    private final SearchSerialBySerialNameRequest searchSerialByName;

    public SerialController(SearchSerialBySerialNameRequest searchSerialByName) {
        this.searchSerialByName = searchSerialByName;
    }

    @GetMapping
    public SearchByNameDto getSerialFromName(@RequestParam("name") String name) {
        return searchSerialByName.get(name).toSearchByNameDto();
    }

}
