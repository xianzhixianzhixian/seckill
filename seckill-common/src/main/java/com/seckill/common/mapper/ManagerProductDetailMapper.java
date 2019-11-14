package com.seckill.common.mapper;

import com.seckill.common.bean.ManagerProductDetail;
import com.seckill.common.bean.ManagerProductDetailExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ManagerProductDetailMapper {
    long countByExample(ManagerProductDetailExample example);

    int deleteByExample(ManagerProductDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ManagerProductDetail record);

    int insertSelective(ManagerProductDetail record);

    List<ManagerProductDetail> selectByExample(ManagerProductDetailExample example);

    ManagerProductDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ManagerProductDetail record, @Param("example") ManagerProductDetailExample example);

    int updateByExample(@Param("record") ManagerProductDetail record, @Param("example") ManagerProductDetailExample example);

    int updateByPrimaryKeySelective(ManagerProductDetail record);

    int updateByPrimaryKey(ManagerProductDetail record);
}