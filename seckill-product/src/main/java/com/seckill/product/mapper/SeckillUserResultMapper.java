package com.seckill.product.mapper;

import com.seckill.common.bean.SeckillUserResult;
import com.seckill.common.bean.SeckillUserResultExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SeckillUserResultMapper {
    long countByExample(SeckillUserResultExample example);

    int deleteByExample(SeckillUserResultExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SeckillUserResult record);

    int insertSelective(SeckillUserResult record);

    List<SeckillUserResult> selectByExample(SeckillUserResultExample example);

    SeckillUserResult selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SeckillUserResult record, @Param("example") SeckillUserResultExample example);

    int updateByExample(@Param("record") SeckillUserResult record, @Param("example") SeckillUserResultExample example);

    int updateByPrimaryKeySelective(SeckillUserResult record);

    int updateByPrimaryKey(SeckillUserResult record);
}