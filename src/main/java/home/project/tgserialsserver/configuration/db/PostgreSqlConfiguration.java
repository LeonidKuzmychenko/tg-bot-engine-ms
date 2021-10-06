package home.project.tgserialsserver.configuration.db;

import org.hibernate.boot.SchemaAutoTooling;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class PostgreSqlConfiguration {

    @Value("${heroku.db.postgres.url}")
    private String url;

    @Value("${heroku.db.postgres.user}")
    private String user;

    @Value("${heroku.db.postgres.password}")
    private String password;

    @Bean(name = "mainJpaDataSource")
    public DataSource dataSource() {
        DriverManagerDataSource driver = new DriverManagerDataSource();
        driver.setDriverClassName("org.postgresql.Driver");
        driver.setUrl(url);
        driver.setUsername(user);
        driver.setPassword(password);
        return driver;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            @Qualifier("mainJpaDataSource") DataSource dataSource,
            @Qualifier("mainJpaHibernateJpaVendorAdapter") HibernateJpaVendorAdapter adapter,
            @Qualifier("mainJpaProperties") Properties properties,
            @Qualifier("mainJpaModelPaths") String[] modelPaths) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setPackagesToScan(modelPaths);
        factory.setDataSource(dataSource);
        factory.setJpaVendorAdapter(adapter);
        factory.setJpaProperties(properties);
        return factory;
    }

    @Bean(name = "mainJpaModelPaths")
    public String[] jpaModelPaths() {
        return new String[]{
                "home.project.tgserialsserver.configuration.model"
        };
    }

    @Bean(name = "mainJpaHibernateJpaVendorAdapter")
    public HibernateJpaVendorAdapter jpaHibernateJpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setDatabase(Database.POSTGRESQL);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setShowSql(false);
        return hibernateJpaVendorAdapter;
    }

    @Bean(name = "mainJpaProperties")
    public Properties jpaProperties() {
        Properties properties = new Properties();
        properties.put(AvailableSettings.HBM2DDL_AUTO, getDDL(SchemaAutoTooling.CREATE_DROP));
        return properties;
    }

    private String getDDL(SchemaAutoTooling schemaAutoTooling) {
        return schemaAutoTooling.name().replace("_", "-").toLowerCase();
    }

}