package com.seckill.shop.mapper;

import com.seckill.common.bean.SeckillShop;
import com.seckill.shop.bean.SeckillShopExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SeckillShopMapper {
    long countByExample(SeckillShopExample example);

    int deleteByExample(SeckillShopExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SeckillShop record);

    int insertSelective(SeckillShop record);

    List<SeckillShop> selectByExample(SeckillShopExample example);

    SeckillShop selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SeckillShop record, @Param("example") SeckillShopExample example);

    int updateByExample(@Param("record") SeckillShop record, @Param("example") SeckillShopExample example);

    int updateByPrimaryKeySelective(SeckillShop record);

    int updateByPrimaryKey(SeckillShop record);
}