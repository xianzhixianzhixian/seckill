package com.seckill.product.mapper;

import com.seckill.common.bean.SeckillProduct;
import com.seckill.common.bean.SeckillProductExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SeckillProductMapper {
    long countByExample(SeckillProductExample example);

    int deleteByExample(SeckillProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SeckillProduct record);

    int insertSelective(SeckillProduct record);

    List<SeckillProduct> selectByExample(SeckillProductExample example);

    SeckillProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SeckillProduct record, @Param("example") SeckillProductExample example);

    int updateByExample(@Param("record") SeckillProduct record, @Param("example") SeckillProductExample example);

    int updateByPrimaryKeySelective(SeckillProduct record);

    int updateByPrimaryKey(SeckillProduct record);
}