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
	 * @param id
	 * @return User
	 */
	public User getUserById(int userId)
	{
		return userMapper.selectByPrimaryKey(userId);
	}
	
	
	/**
	 * 
	 * 登录
	 * 验证账号密码
	 * @param account
	 * @param password
	 * @return User
	 */
	
	public User login(String account,String password)
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
	public boolean updateUser(User user)
	{
		
		 int flag=userMapper.updateByPrimaryKey(user);
		 if(flag==1)
			 return true;
		 return false;
	}
	
	
	/**
	 * 注册用户
	 * @param user
	 * @return User
	 */
	public User insertUser(User user)
	{
		
		userMapper.insertSelective(user);
		
		return login(user.getUserAccount(),user.getUserPassword());
		
	}
	
	
	
	
}
