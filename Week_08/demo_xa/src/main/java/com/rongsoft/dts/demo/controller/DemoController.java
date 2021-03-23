package com.rongsoft.dts.demo.controller;


import com.rongsoft.dts.demo.service.TbGoodsService;
import com.rongsoft.dts.demo.service.TbOrderService;
import com.rongsoft.dts.demo.service.TbUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    public TbOrderService orderService;
    @Autowired
    public TbGoodsService goodsService;
    @Autowired
    public TbUserService tbUserService;

    @GetMapping("/insertOrder")
    public void insertOrder(@RequestParam("id") Long id,@RequestParam("begin") Long begin,@RequestParam("size") Long size){
        log.info("开始处理数据，id：{}，begin：{},size:{}",id,begin,size);
        for(int i=0;i<size;i++){
            tbUserService.insertUser(begin+i);
            goodsService.insertGoods(begin+i,begin+i);
            orderService.insertOrder(begin+i,begin+i,begin+i);
        }
        log.info("结束处理数据，id：{}，begin：{}",id,begin);
    }

    @GetMapping("/insertXAOrder")
    public void insertXAOrder(@RequestParam("id") Long id,@RequestParam("begin") Long begin,@RequestParam("size") Long size){
        log.info("开始处理数据，id：{}，begin：{},size:{}",id,begin,size);
        for(int i=0;i<size;i++){
            orderService.insertXAOrder(begin+i,begin+i,begin+i);
        }
        log.info("结束处理数据，id：{}，begin：{}",id,begin);
    }

    @GetMapping("/insertOnlyOrder")
    public void insertOnlyOrder(@RequestParam("id") Long id,@RequestParam("begin") Long begin,@RequestParam("size") Long size){
        log.info("开始处理数据，id：{}，begin：{},size:{}",id,begin,size);
        for(int i=0;i<size;i++){
            orderService.insertOrder(begin+i,begin+i,begin+i);
        }
        log.info("结束处理数据，id：{}，begin：{}",id,begin);
    }


}
