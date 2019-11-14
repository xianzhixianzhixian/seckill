package com.seckill.common.mapper;

import com.seckill.common.bean.ManagerUser;
import com.seckill.common.bean.ManagerUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ManagerUserMapper {
    long countByExample(ManagerUserExample example);

    int deleteByExample(ManagerUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ManagerUser record);

    int insertSelective(ManagerUser record);

    List<ManagerUser> selectByExample(ManagerUserExample example);

    ManagerUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ManagerUser record, @Param("example") ManagerUserExample example);

    int updateByExample(@Param("record") ManagerUser record, @Param("example") ManagerUserExample example);

    int updateByPrimaryKeySelective(ManagerUser record);

    int updateByPrimaryKey(ManagerUser record);
}