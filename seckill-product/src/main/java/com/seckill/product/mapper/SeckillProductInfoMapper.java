package com.seckill.product.mapper;

import com.seckill.common.bean.SeckillProductInfo;
import com.seckill.product.bean.SeckillProductInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SeckillProductInfoMapper {
    long countByExample(SeckillProductInfoExample example);

    int deleteByExample(SeckillProductInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SeckillProductInfo record);

    int insertSelective(SeckillProductInfo record);

    List<SeckillProductInfo> selectByExample(SeckillProductInfoExample example);

    SeckillProductInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SeckillProductInfo record, @Param("example") SeckillProductInfoExample example);

    int updateByExample(@Param("record") SeckillProductInfo record, @Param("example") SeckillProductInfoExample example);

    int updateByPrimaryKeySelective(SeckillProductInfo record);

    int updateByPrimaryKey(SeckillProductInfo record);
}