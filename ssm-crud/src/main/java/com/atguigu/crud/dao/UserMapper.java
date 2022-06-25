package com.atguigu.crud.dao;

import com.atguigu.crud.bean.User;
import com.atguigu.crud.bean.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	//自定义条件求总数
    long countByExample(UserExample example);
    //自定义条件删除
    int deleteByExample(UserExample example);
    //通过主键删除
    int deleteByPrimaryKey(Integer userId);
    //插入所有
    int insert(User record);
    //插入非空
    int insertSelective(User record);
    //自定义查询
    List<User> selectByExample(UserExample example);
    //通过主键查询
    User selectByPrimaryKey(Integer userId);
    //修改非空，加条件
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);
    //修改所有，加条件
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
    //修改非空
    int updateByPrimaryKeySelective(User record);
    //修改所有
    int updateByPrimaryKey(User record);
}