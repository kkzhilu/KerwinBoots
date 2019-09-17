package com.boot.source;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/16 10:52
 * description:  DynamicRoutingDataSource
 * version:      V1.0
 * ******************************
 */
// 名字(dataSource)  Primary  Priority
@Component
@Primary // 多个DataSource Bean 因此@Primary 将作为首选者
         // @Priority 优先级
         // 多个按类型的dataSource 为了让它找到bean可以给当前bean修改 名称 -> @Component(value = "dataSource")
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    private static Logger logger = LoggerFactory.getLogger(DynamicRoutingDataSource.class);

    @Autowired
    @Qualifier("selectDataSource")
    private DataSource selectDataSource;

    @Autowired
    @Qualifier("updateDataSource")
    private DataSource updateDataSource;

    @Override
    protected Object determineCurrentLookupKey() {
        logger.info("切换数据源: " + DataSourceContextHolder.getDbType());
        return DataSourceContextHolder.getDbType();
    }

    /**
     * 重写after配置方法, 配置默认数据源
     */
    @Override
    public void afterPropertiesSet() {
        Map<Object,Object> map = new HashMap<>();
        map.put("selectDataSource", selectDataSource);
        map.put("updateDataSource", updateDataSource);
        setTargetDataSources(map);
        setDefaultTargetDataSource(updateDataSource);
        super.afterPropertiesSet();
    }
}
