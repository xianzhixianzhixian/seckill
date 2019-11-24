package com.seckill.manager.merchant.mapper;

import com.seckill.common.bean.ManagerMerchant;
import com.seckill.common.bean.ManagerMerchantExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ManagerMerchantMapper {
    long countByExample(ManagerMerchantExample example);

    int deleteByExample(ManagerMerchantExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ManagerMerchant record);

    int insertSelective(ManagerMerchant record);

    List<ManagerMerchant> selectByExample(ManagerMerchantExample example);

    ManagerMerchant selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ManagerMerchant record, @Param("example") ManagerMerchantExample example);

    int updateByExample(@Param("record") ManagerMerchant record, @Param("example") ManagerMerchantExample example);

    int updateByPrimaryKeySelective(ManagerMerchant record);

    int updateByPrimaryKey(ManagerMerchant record);
}