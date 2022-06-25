package com.atguigu.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Restaurant;
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
		return null;
		
	}
	
	
	
}
