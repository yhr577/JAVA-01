package com.rongsoft.dts.demo.service;

import com.alibaba.fastjson.JSON;
import com.rongsoft.dts.demo.dao.entity.CardBin;
import com.rongsoft.dts.demo.dao.mapper.CardBinMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Slf4j
@Service
public class CardBinService {

    @Autowired
    public CardBinMapper cardBinMapper;

    public CardBin getCardBinWithSharding(String cardBinId) {

        //如果不设置,默认master查询
        CardBin slaveCardBin = cardBinMapper.selectById(cardBinId);
        log.info("slave:{}",JSON.toJSONString(slaveCardBin));
        slaveCardBin.setCardBinId("1000");
        int insertMaster = cardBinMapper.insert(slaveCardBin);
        log.info("插入结果：{}",insertMaster);


        return slaveCardBin;

    }


}
