package tg.project.engine.mapper;


import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import tg.project.engine.api.kinopoisk.requests.getepisodesinfobyserialid.response.Episode;
import tg.project.engine.dtos.FormattedEpisodeDto;

import javax.annotation.PostConstruct;

import static org.springframework.util.StringUtils.hasLength;

@Component
public class EpisodeMapper {

    private final ModelMapper modelMapper;

    public EpisodeMapper() {
        this.modelMapper = new ModelMapper();
    }

    @PostConstruct
    public void configure() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.createTypeMap(Episode.class, FormattedEpisodeDto.class)
                .addMappings(new PropertyMap<>() {
                    @Override
                    protected void configure() {
                        using(ctx -> {
                                    Episode source = (Episode) ctx.getSource();
                                    if (hasLength(source.getNameRu())) return source.getNameRu();
                                    if (hasLength(source.getNameEn())) return source.getNameEn();
                                    return "";
                                }
                        ).map(source, destination.getName());
                    }
                });
    }

    public FormattedEpisodeDto toFormattedEpisode(Episode episode) {
        return modelMapper.map(episode, FormattedEpisodeDto.class);
    }
}