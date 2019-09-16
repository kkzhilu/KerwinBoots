package com.boot.source;


import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/16 10:52
 * description:  DynamicRoutingDataSource
 * version:      V1.0
 * ******************************
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        logger.info("切换数据源: " + DataSourceContextHolder.getDbType());
        return DataSourceContextHolder.getDbType();
    }
}
