package home.project.tgserialsserver.configuration.controllers;

import home.project.tgserialsserver.configuration.dto.FoundedFilmDto;
import home.project.tgserialsserver.configuration.services.SerialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/serial")
public class SerialController {
    //(сохранить сериал)
    @Autowired
    private SerialService serialService;
    @GetMapping("/search")
    public ResponseEntity<FoundedFilmDto> searchByName(@RequestParam("id") String chatId, @RequestParam("name") String nameFilm) {
        FoundedFilmDto foundedFilmDto = serialService.findSerialByName(chatId, nameFilm);
        return new ResponseEntity<>(foundedFilmDto, HttpStatus.OK);
    }
}
