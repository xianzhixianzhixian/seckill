package com.seckill.user.mapper;

import com.seckill.user.bean.SeckillUser;
import com.seckill.user.bean.SeckillUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SeckillUserMapper {

    long countByExample(SeckillUserExample example);

    int deleteByExample(SeckillUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SeckillUser record);

    int insertSelective(SeckillUser record);

    List<SeckillUser> selectByExample(SeckillUserExample example);

    SeckillUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SeckillUser record, @Param("example") SeckillUserExample example);

    int updateByExample(@Param("record") SeckillUser record, @Param("example") SeckillUserExample example);

    int updateByPrimaryKeySelective(SeckillUser record);

    int updateByPrimaryKey(SeckillUser record);
}