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
		return null;
		
//		  UserExample user = new UserExample();
//		  
//		  user.getOredCriteria().get(0).andUserAccountEqualTo(account);
//		  user.getOredCriteria().get(0).andUserPasswordEqualTo(password);
//		  
//		  return (User) userMapper.selectByExample(user);
//		 
//		User user = new User();
//		user.setUserAccount(account);
//		user.setUserPassword(password);
//		return userMapper.selectByUserNameAndPsd(user);
	}
	/**
	 * 顾客使用
	 * 修改个人信息，返回boolean 
	 * @param users
	 * @return Boolean
	 */
	public boolean UpdateUser(User users)
	{
		
		return true;
	}
	
	
}
