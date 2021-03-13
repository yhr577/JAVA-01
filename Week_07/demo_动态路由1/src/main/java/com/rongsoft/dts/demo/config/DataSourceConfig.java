package com.rongsoft.dts.demo.config;

import com.rongsoft.dts.demo.common.Constants;
import com.rongsoft.dts.demo.common.MySQLRoutingDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


@Configuration
public class DataSourceConfig {

    @Bean(Constants.DS_KEY_MASTER)
    @ConfigurationProperties(prefix = "spring.datasource.hikari.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(Constants.DS_KEY_SLAVE1)
    @ConfigurationProperties(prefix = "spring.datasource.hikari.slave1")
    public DataSource slave1DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(Constants.DS_KEY_SLAVE2)
    @ConfigurationProperties(prefix = "spring.datasource.hikari.slave2")
    public DataSource slave2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        Map<Object, Object> dataSourceMap = new HashMap<>(3);
        dataSourceMap.put(Constants.DS_KEY_MASTER, masterDataSource());
        dataSourceMap.put(Constants.DS_KEY_SLAVE1, slave1DataSource());
        dataSourceMap.put(Constants.DS_KEY_SLAVE2, slave2DataSource());
        //设置动态数据源
        MySQLRoutingDataSource dynamicDataSource = new MySQLRoutingDataSource();
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource());

        return dynamicDataSource;
    }

}
