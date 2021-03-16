package com.rongsoft.dts.demo.service;

import com.rongsoft.dts.demo.dao.entity.TbUsers;
import com.rongsoft.dts.demo.dao.mapper.TbUsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;


@Slf4j
@Service
public class TbUserService {

    @Autowired
    public TbUsersMapper tbUsersMapper;


    public void insertUser(Long id){
        TbUsers tbUsers = TbUsers.builder().id(id).userName("name"+id).address("广州").amount(new BigDecimal(10000))
                .idCard("36048719900225"+id).phone("18018"+id).createTime(new Date()).password("士大夫撒旦发祝福色粉").updateTime(new Date()).build();
        tbUsersMapper.insert(tbUsers);
    }


}
