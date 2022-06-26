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
	 * 登录
	 * @param account
	 * @param password
	 * @return Restaurant
	 */
	public Restaurant login(String account,String password)
	{
		
		RestaurantExample re = new RestaurantExample();
		RestaurantExample.Criteria criteria = re.createCriteria();
		criteria.andRestaurantAccountEqualTo(account);
	    criteria.andRestaurantPasswordEqualTo(password);
	    List<Restaurant> t = restaurantMapper.selectByExample(re);
	    if(t!=null && t.size()!=0) {
	    	 return t.get(0);
	    }
	    return null;
	}
	
	/**
	 *  获取餐厅
	 * @return Restaurant
	 */
	public Restaurant getRestaurant()
	{
		return restaurantMapper.selectByExample(null).get(0);
		
		
	}
	/**
	 * 修改餐厅信息
	 * @param r
	 * @return Boolean
	 */
	public boolean updateRestaurant(Restaurant r)
	{
		
		int flag=restaurantMapper.updateByExampleSelective(r, null);
		if(flag==1)
			return true;
		return false;
		
	}
	
	
}
