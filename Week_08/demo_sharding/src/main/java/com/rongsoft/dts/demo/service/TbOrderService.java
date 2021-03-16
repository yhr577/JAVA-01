package com.rongsoft.dts.demo.service;

import com.rongsoft.dts.demo.dao.entity.TbOrder;
import com.rongsoft.dts.demo.dao.mapper.TbOrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Slf4j
@Service
public class TbOrderService {

    @Autowired
    public TbOrderMapper tbOrderMapper;

    public TbOrder insertOrder(Long goodsId, Long userId, Long orderId) {

        //插入数据
        TbOrder order = TbOrder.builder()
                .id(orderId)
                .address("广州")
                .goodsId(goodsId)
                .userId(userId)
                .amount(new BigDecimal(10))
                .phone("18945698752")
                .createTime(new Date())
                .updateTime(new Date())
                .build();

        int insertRet = tbOrderMapper.insert(order);
        log.info("插入结果：{}",insertRet);

        return null;

    }

}
