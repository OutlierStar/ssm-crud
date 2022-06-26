package com.atguigu.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.Restaurant;
import com.atguigu.crud.bean.Sort;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.service.OrderService;
import com.atguigu.crud.service.RestaurantService;
import com.atguigu.crud.service.SortService;
import com.atguigu.crud.service.UserService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping("/login")
	public Msg login(String account,String password) {//餐厅登录
		
		Restaurant restaurant  = restaurantService.login(account,password);
		
		if(restaurant != null) {//不为空，则成功
			
			return Msg.success().add("restaurant", restaurant);
			
		}else {//失败
			
			
			return Msg.fail().add("restaurant", null);
			
		}
		
	}
	@RequestMapping("/update")
	public Msg update(Restaurant restaurant) {//修改餐厅信息
		
		Boolean bool = restaurantService.updateRestaurant(restaurant);
		
		if(bool) {//不为空，则成功
			
			return Msg.success();
			
		}else {//失败
			
			
			return Msg.fail();
			
		}
		
	}
	@RequestMapping("/get")
	public Msg get() {//获取餐厅信息
		
		Restaurant restaurant = restaurantService.getRestaurant();
		
		if(restaurant!=null) {//不为空，则成功
			
			return Msg.success().add("restaurant", restaurant);
			
		}else {//失败
			
			
			return Msg.fail().add("restaurant", null);
			
		}
	}
	
}



