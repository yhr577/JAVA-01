package com.rongsoft.dts.demo.service;

import com.rongsoft.dts.demo.dao.entity.TbGoods;
import com.rongsoft.dts.demo.dao.mapper.TbGoodsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;


@Slf4j
@Service
public class TbGoodsService {

    @Autowired
    public TbGoodsMapper tbGoodsMapper;


    public void insertGoods(Long id,Long userId){
        TbGoods goods = TbGoods.builder().id(id).belong(id).belong(userId).amount(new BigDecimal(10000))
                .updateTime(new Date()).build();
        tbGoodsMapper.insert(goods);
    }

}
