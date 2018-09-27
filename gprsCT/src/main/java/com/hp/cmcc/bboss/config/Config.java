package com.hp.cmcc.bboss.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class Config {
	
	@Bean(name = "Template")
	public JdbcTemplate bdcCompareJdbcTemplate(@Qualifier("DataSource") DataSource dataSource) {
	    return new JdbcTemplate(dataSource);
	}
	
	@Bean(name = "DataSource")
    @Qualifier("DataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource bdcCompareDataSource() {
        return DataSourceBuilder.create().build();
    }
}

