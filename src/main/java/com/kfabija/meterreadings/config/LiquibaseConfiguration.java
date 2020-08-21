package com.kfabija.meterreadings.config;

import liquibase.integration.spring.SpringLiquibase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfiguration {

    private final Logger log = LoggerFactory.getLogger(LiquibaseConfiguration.class);

    public LiquibaseConfiguration() {
    }

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        log.debug("Enabling liquibase properties");
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:liquibase/master.xml");
        return liquibase;
    }
}
