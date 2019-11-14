package com.seckill.common.mapper;

import com.seckill.common.bean.ManagerProductInfo;
import com.seckill.common.bean.ManagerProductInfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ManagerProductInfoMapper {
    long countByExample(ManagerProductInfoExample example);

    int deleteByExample(ManagerProductInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ManagerProductInfo record);

    int insertSelective(ManagerProductInfo record);

    List<ManagerProductInfo> selectByExample(ManagerProductInfoExample example);

    ManagerProductInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ManagerProductInfo record, @Param("example") ManagerProductInfoExample example);

    int updateByExample(@Param("record") ManagerProductInfo record, @Param("example") ManagerProductInfoExample example);

    int updateByPrimaryKeySelective(ManagerProductInfo record);

    int updateByPrimaryKey(ManagerProductInfo record);
}