package com.seckill.manager.producttype.mapper;

import com.seckill.common.bean.ManagerProductType;
import com.seckill.common.bean.ManagerProductTypeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ManagerProductTypeMapper {
    long countByExample(ManagerProductTypeExample example);

    int deleteByExample(ManagerProductTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ManagerProductType record);

    int insertSelective(ManagerProductType record);

    List<ManagerProductType> selectByExample(ManagerProductTypeExample example);

    ManagerProductType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ManagerProductType record, @Param("example") ManagerProductTypeExample example);

    int updateByExample(@Param("record") ManagerProductType record, @Param("example") ManagerProductTypeExample example);

    int updateByPrimaryKeySelective(ManagerProductType record);

    int updateByPrimaryKey(ManagerProductType record);
}