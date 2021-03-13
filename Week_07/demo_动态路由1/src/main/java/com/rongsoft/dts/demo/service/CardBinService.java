package com.rongsoft.dts.demo.service;

import com.alibaba.fastjson.JSON;
import com.rongsoft.dts.demo.annotation.DyDataSource;
import com.rongsoft.dts.demo.common.Constants;
import com.rongsoft.dts.demo.common.DynamicDataSourceContextHolder;
import com.rongsoft.dts.demo.dao.entity.CardBin;
import com.rongsoft.dts.demo.dao.mapper.CardBinMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class CardBinService {

    @Autowired
    public CardBinMapper cardBinMapper;

    @DyDataSource(value = Constants.DS_KEY_SLAVE_WITH_ROUTER )
    public CardBin getCardBinWithDataSource(String cardBinId) {
        //如果不设置,默认master查询
        CardBin slaveCardBin = cardBinMapper.selectById(cardBinId);
        log.info("slave:{}",JSON.toJSONString(slaveCardBin));

//        CardBin masterCardBin = getMasterCardBin(cardBinId);
        CardBinService cardBinService = (CardBinService) AopContext.currentProxy();
        CardBin masterCardBin = cardBinService.getMasterCardBin(cardBinId);

        return masterCardBin;

    }

    @DyDataSource(value = Constants.DS_KEY_MASTER)
    public CardBin getMasterCardBin(String cardBinId){
        CardBin cardBin = cardBinMapper.selectById(cardBinId);
        log.info("master:{}",JSON.toJSONString(cardBin));
        return cardBin;
    }

    //手工设置 datasource
    public CardBin getCardBin(String cardBinId) {
        //默认master查询
        CardBin masterCardBin = cardBinMapper.selectById(cardBinId);
        log.info("master:{}",JSON.toJSONString(masterCardBin));
        //设置slave
        DynamicDataSourceContextHolder.setContextKey(Constants.DS_KEY_SLAVE1);
        CardBin slaveCardBin = cardBinMapper.selectById(cardBinId);
        log.info("slave:{}",JSON.toJSONString(slaveCardBin));
        return masterCardBin;

    }


}
