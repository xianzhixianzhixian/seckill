package com.seckill.merchant.mapper;

import com.seckill.common.bean.SeckillMerchant;
import com.seckill.merchant.bean.SeckillMerchantExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SeckillMerchantMapper {
    long countByExample(SeckillMerchantExample example);

    int deleteByExample(SeckillMerchantExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SeckillMerchant record);

    int insertSelective(SeckillMerchant record);

    List<SeckillMerchant> selectByExample(SeckillMerchantExample example);

    SeckillMerchant selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SeckillMerchant record, @Param("example") SeckillMerchantExample example);

    int updateByExample(@Param("record") SeckillMerchant record, @Param("example") SeckillMerchantExample example);

    int updateByPrimaryKeySelective(SeckillMerchant record);

    int updateByPrimaryKey(SeckillMerchant record);
}