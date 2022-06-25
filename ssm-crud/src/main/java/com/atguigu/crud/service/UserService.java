package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.User;
import com.atguigu.crud.bean.UserExample;
import com.atguigu.crud.dao.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	/**餐厅使用
	 * 获取所有用户
	 * @return List<User>
	 */
	public List<User> getAllUser()
	{
		return userMapper.selectByExample(null);
	}
	
	/**
	 * 顾客使用
	 * 查询个人信息
	 * 根据用户ID获取用户信息，返回User类
	 * @param id
	 * @return User
	 */
	public User getUserById( int id)
	{
		return userMapper.selectByPrimaryKey(id);
	}
	
	
	/**
	 * 
	 * 登录验证
	 * 验证账号密码
	 * @param account
	 * @param password
	 * @return User
	 */
	
	public User check(String account,String password)
	{
		
		
		  UserExample user = new UserExample();
		  
		  UserExample.Criteria criteria = user.createCriteria(); //构造自定义查询条件
	      criteria.andUserAccountEqualTo(account);
	      criteria.andUserPasswordEqualTo(password);	      
	      
	      List<User> t = userMapper.selectByExample(user);
	      if(t != null&&t.size()!=0) {//判断列表不为空
	    	  return t.get(0);
	      }
	      
	      return null;
	      
	}
	/**
	 * 顾客使用
	 * 修改个人信息
	 * @param users
	 * @return 
	 */
	public void updateUser(User user)
	{
		
		 userMapper.updateByPrimaryKey(user);
		
	}
	
	
	/**
	 * 注册用户
	 * @param users
	 */
	public void insertUser(User user)
	{
		
		userMapper.insertSelective(user);
	}
	
	
	
	
}
