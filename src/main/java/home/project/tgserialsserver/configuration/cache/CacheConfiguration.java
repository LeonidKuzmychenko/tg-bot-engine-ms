package home.project.tgserialsserver.configuration.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfiguration {
    @Bean("SearchSerialCache")
    //first String for chat Id, second String for serial ID
    public Cache<String, String> cache() {
        return CacheBuilder.newBuilder()
                .expireAfterWrite(365, TimeUnit.DAYS)
                .build();
    }

}
