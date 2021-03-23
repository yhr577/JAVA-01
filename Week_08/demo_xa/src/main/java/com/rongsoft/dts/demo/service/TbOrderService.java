package com.rongsoft.dts.demo.service;

import com.rongsoft.dts.demo.dao.entity.TbGoods;
import com.rongsoft.dts.demo.dao.entity.TbOrder;
import com.rongsoft.dts.demo.dao.entity.TbUsers;
import com.rongsoft.dts.demo.dao.mapper.TbGoodsMapper;
import com.rongsoft.dts.demo.dao.mapper.TbOrderMapper;
import com.rongsoft.dts.demo.dao.mapper.TbUsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Slf4j
@Service
public class TbOrderService {

    @Autowired
    public TbOrderMapper tbOrderMapper;
    @Autowired
    public TbUsersMapper tbUsersMapper;
    @Autowired
    public TbGoodsMapper tbGoodsMapper;


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

    @Transactional(rollbackFor = Exception.class)
    @ShardingTransactionType(TransactionType.XA)
    public void insertXAOrder(Long id,Long userId,Long goodsId){
        log.info("开始执行事务-------");
        TbUsers tbUsers = TbUsers.builder().id(id).userName("name"+id).address("广州").amount(new BigDecimal(10000))
                .idCard("36048719900225"+id).phone("18018"+id).createTime(new Date()).password("士大夫撒旦发祝福色粉").updateTime(new Date()).build();
        tbUsersMapper.insert(tbUsers);

        TbGoods goods = TbGoods.builder().id(id).belong(id).belong(userId).amount(new BigDecimal(10000))
                .updateTime(new Date()).build();
        tbGoodsMapper.insert(goods);

        TbOrder order = TbOrder.builder().id(id).address("广州").goodsId(goodsId).userId(userId).amount(new BigDecimal(10))
                .phone("18945698752").createTime(new Date()).updateTime(new Date()).build();
        int insertRet = tbOrderMapper.insert(order);

        log.info("执行事务结束-----------");
    }

}
