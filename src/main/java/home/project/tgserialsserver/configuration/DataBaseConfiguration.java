package home.project.tgserialsserver.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
//@EntityScan("home.project.tgserialsserver.model")
//@EnableJpaRepositories("home.project.tgserialsserver.repository")
public class DataBaseConfiguration {

    @Bean
    @ConfigurationProperties("pg.data-source")
    public DataSource pgDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}