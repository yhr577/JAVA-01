package com.rongsoft.dts.demo.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 随机路由
 */
@Component
public class RandomDataSourceRouter implements DyDataSourceRouter {

    @Autowired
    public DataSource dataSource;

    public String selectRouter(String prefix){
        Assert.notNull(prefix,"路由器名称前缀不能为空");
        MySQLRoutingDataSource mySQLRoutingDataSource = (MySQLRoutingDataSource) dataSource;
        Map<Object, DataSource> dataSourceMap = mySQLRoutingDataSource.getResolvedDataSources();
        //如果已经存在同名key,则不路由
        if (dataSourceMap.get(prefix)!=null){
            return prefix;
        }
        List<Object> dataSourceKeyList = dataSourceMap.keySet().stream().filter( key -> StringUtils.startsWithIgnoreCase(String.valueOf(key),prefix)).sorted().collect(Collectors.toList());
        Random random = new Random();
        int randomInt = random.nextInt(dataSourceKeyList.size());
        String retDataSourceKey = (String) dataSourceKeyList.get(randomInt);
        return retDataSourceKey;
    }
}
