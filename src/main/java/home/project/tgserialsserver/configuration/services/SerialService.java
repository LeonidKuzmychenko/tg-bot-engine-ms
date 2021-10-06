package home.project.tgserialsserver.configuration.services;

import com.google.common.cache.Cache;
import home.project.tgserialsserver.configuration.dto.Film;
import home.project.tgserialsserver.configuration.dto.FoundedFilmDto;
import home.project.tgserialsserver.configuration.model.Serial;
import home.project.tgserialsserver.configuration.repository.SerialRepository;
import home.project.tgserialsserver.http.SearchByName;
import home.project.tgserialsserver.http.SerialById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerialService {

    @Autowired
    private SerialRepository serialRepository;
    @Autowired
    private SearchByName searchByName;
    @Autowired
    private SerialById serialById;
    @Autowired
    @Qualifier("SearchSerialCache")
    private Cache<String ,String > cache;
    //закешировать найденный результат Cache<String(chatId),String(serialId)>

    public FoundedFilmDto findSerialByName(String chatId, String searchName) {
        Film film = searchByName.get(searchName);
        String filmId = film.getFilmId().toString();
        cache.put(chatId,filmId);
        String nameEn = film.getNameEn();
        String posterUrl = film.getPosterUrl();
        return new FoundedFilmDto(nameEn,posterUrl);
    }

    //create controller
    public List<Serial> findSubscribeSerialsByChatId(String chatId) {
        //TODO HTTP request (@Component)
        //create DTO
        //fullname
        //poster(http)
        return null;
    }

}
