package com.atguigu.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.service.OrderService;
import com.atguigu.crud.service.UserService;

@Controller

public class UserController {
	
	@Autowired
	private UserService userService;
	
	public Msg login(User user) {
		
		User userRight = userService.check(user.getUserAccount(), user.getUserPassword());
		
		if(userRight != null) {//不为空，则登陆成功
			
			
			return Msg.success().add("user", userRight);
			
		}else {//登陆失败
			
			
			return Msg.fail().add("user", null);
			
		}
		
	}
	
	
	
}
