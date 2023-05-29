package com.practice.catalogservice.configuration;

import com.practice.catalogservice.properties.DataSourceProperties;
import com.practice.catalogservice.properties.LiquibaseProperties;
import liquibase.integration.spring.SpringLiquibase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@Slf4j
public class LiquibaseConfiguration {
    final String SCHEMA = "catalog";
    @Autowired
    private LiquibaseProperties liquibaseProperties;

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Autowired
    private DataSource dataSource;

    @Bean
    public SpringLiquibase liquibase(JdbcTemplate jdbcTemplate) {
        log.info("Start init liquibase");

//        createSchema(jdbcTemplate, SCHEMA);

        SpringLiquibase liquibase = new SpringLiquibase();

        liquibase.setChangeLog("classpath:/changelog/db.changelog.yaml");
        liquibase.setDataSource(dataSource);
        liquibase.setLiquibaseSchema(SCHEMA);
        liquibase.setDefaultSchema(SCHEMA);

        Map<String, String> parameters = new HashMap<>();
        parameters.put("usrName", dataSourceProperties.getUserName());
        parameters.put("userPassword", dataSourceProperties.getPassword());
        parameters.put("schema", SCHEMA);
        parameters.put("roleName", liquibaseProperties.getRoleName());

        liquibase.setChangeLogParameters(parameters);

        log.info("Init liquibase success");
        return liquibase;
    }

    private void createSchema(JdbcTemplate jdbcTemplate, String schema) {
        log.info("Start creating schema");
        String query = "CREATE SCHEMA IF NOT EXISTS " + SCHEMA + " AUTHORIZATION " + liquibaseProperties.getUser();
//        String query = String.format("CREATE SCHEMA IF NOT EXISTS %s AUTHORIZATION %s",
//                schema,
//                liquibaseProperties.getUser());

        jdbcTemplate.execute(query);
        log.info("Creating schema success");
    }
}
