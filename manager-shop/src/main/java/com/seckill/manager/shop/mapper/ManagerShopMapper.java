package com.seckill.manager.shop.mapper;

import com.seckill.common.bean.ManagerShop;
import com.seckill.common.bean.ManagerShopExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ManagerShopMapper {
    long countByExample(ManagerShopExample example);

    int deleteByExample(ManagerShopExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ManagerShop record);

    int insertSelective(ManagerShop record);

    List<ManagerShop> selectByExample(ManagerShopExample example);

    ManagerShop selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ManagerShop record, @Param("example") ManagerShopExample example);

    int updateByExample(@Param("record") ManagerShop record, @Param("example") ManagerShopExample example);

    int updateByPrimaryKeySelective(ManagerShop record);

    int updateByPrimaryKey(ManagerShop record);
}