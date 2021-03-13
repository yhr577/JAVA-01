package com.rongsoft.dts.demo.common;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MySQLRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getContextKey();
    }
}
