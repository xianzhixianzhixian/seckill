package com.seckill.merchant.mapper;

import com.seckill.common.bean.SeckillProductType;
import com.seckill.merchant.bean.SeckillProductTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SeckillProductTypeMapper {
    long countByExample(SeckillProductTypeExample example);

    int deleteByExample(SeckillProductTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SeckillProductType record);

    int insertSelective(SeckillProductType record);

    List<SeckillProductType> selectByExample(SeckillProductTypeExample example);

    SeckillProductType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SeckillProductType record, @Param("example") SeckillProductTypeExample example);

    int updateByExample(@Param("record") SeckillProductType record, @Param("example") SeckillProductTypeExample example);

    int updateByPrimaryKeySelective(SeckillProductType record);

    int updateByPrimaryKey(SeckillProductType record);
}