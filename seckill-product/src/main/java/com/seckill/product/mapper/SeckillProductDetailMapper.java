package com.seckill.product.mapper;

import com.seckill.common.bean.SeckillProductDetail;
import com.seckill.product.bean.SeckillProductDetailExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SeckillProductDetailMapper {
    long countByExample(SeckillProductDetailExample example);

    int deleteByExample(SeckillProductDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SeckillProductDetail record);

    int insertSelective(SeckillProductDetail record);

    List<SeckillProductDetail> selectByExample(SeckillProductDetailExample example);

    SeckillProductDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SeckillProductDetail record, @Param("example") SeckillProductDetailExample example);

    int updateByExample(@Param("record") SeckillProductDetail record, @Param("example") SeckillProductDetailExample example);

    int updateByPrimaryKeySelective(SeckillProductDetail record);

    int updateByPrimaryKey(SeckillProductDetail record);
}