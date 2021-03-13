package com.rongsoft.dts.demo.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rongsoft.dts.demo.dao.entity.CardBin;

public interface CardBinMapper extends CustomBaseMapper<CardBin> {

    int deleteById(String cardBinId);

    CardBin selectById(String cardBinId);

    IPage selectAllByPage(Page page);
}