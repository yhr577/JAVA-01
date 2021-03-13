package com.rongsoft.dts.demo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Collection;

public interface CustomBaseMapper<T> extends BaseMapper {

    Integer insertBatchSomeColumn(Collection<T> entityList);

}
