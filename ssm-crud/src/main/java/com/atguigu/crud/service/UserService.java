package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.User;
import com.atguigu.crud.dao.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	
	/*
	 * 
	 * 查询所有用户
	 * 
	 */
	public List<User> getAllUser()
	{
		return userMapper.selectByExample(null);
	}
	
	
	
	
	
	
}
