package com.boot.source;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/16 11:19
 * description:  DataSourceConfig 数据源配置
 * version:      V1.0
 * ******************************
 */
@Configuration
public class DataSourceConfig {

    // application.properteis中对应属性的前缀
    @Bean(name = "selectDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.select")
    public DataSource selectDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "updateDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.update")
    public DataSource updateDataSource() {
        return DataSourceBuilder.create().build();
    }
}
