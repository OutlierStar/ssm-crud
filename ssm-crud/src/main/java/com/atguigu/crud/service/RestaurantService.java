package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Restaurant;
import com.atguigu.crud.bean.RestaurantExample;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.bean.UserExample;
import com.atguigu.crud.dao.RestaurantMapper;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantMapper restaurantMapper;
	/**
	 * 验证账号
	 * @param account
	 * @param password
	 * @return Restaurant
	 */
	public Restaurant check(String account,String password)
	{
		
		/*	  UserExample user = new UserExample();
		  
		  UserExample.Criteria criteria = user.createCriteria(); //构造自定义查询条件
	      criteria.andUserAccountEqualTo(account);
	      criteria.andUserPasswordEqualTo(password);	      
	      
	      List<User> t = userMapper.selectByExample(user);
	      
	      return t.get(0);*/
		
		RestaurantExample re = new RestaurantExample();
		RestaurantExample.Criteria criteria = re.createCriteria();
		return null;
		
		
		
	}
	
	
	
}
