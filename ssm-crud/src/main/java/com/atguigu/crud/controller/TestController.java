package com.atguigu.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.crud.bean.User;
import com.atguigu.crud.service.MealsService;
import com.atguigu.crud.service.OrderInformationService;
import com.atguigu.crud.service.OrderService;
import com.atguigu.crud.service.RestaurantService;
import com.atguigu.crud.service.ShoppingCartService;
import com.atguigu.crud.service.SortService;
import com.atguigu.crud.service.UserService;
@Controller
public class TestController {
	
	@Autowired
	private MealsService meals;
	private OrderInformationService orderInformation;
	private OrderService order;
	private RestaurantService restaurant;
	private ShoppingCartService shoppingCart;
	private SortService sort;
	
	@Autowired
	private UserService user;
	
	
	@RequestMapping("/test")
	public void test()
	{
		
//		List<User> list=user.getAllUser();
//		
//		for(User t:list)
//			System.out.println(t.getUserName());
		User t= user.check("123", "123");
		t.setUserSex(0);
		user.updateUser(t);
		
		User u = new User();
		u.setUserAccount("999");
		u.setUserPassword("222");
		
		user.insertUser(u);
		//System.out.println(t.getUserName());
		
		
	}
	
}
