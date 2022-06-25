package com.atguigu.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.service.OrderService;
import com.atguigu.crud.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public Msg login(User user) {//登录
		
		User userRight = userService.check(user.getUserAccount(), user.getUserPassword());
		
		if(userRight != null) {//不为空，则登陆成功
			
			
			return Msg.success().add("user", userRight);
			
		}else {//登陆失败
			
			
			return Msg.fail().add("user", null);
			
		}
		
	}
	
	@RequestMapping("/register")
	public Msg register(User user) {//注册
		
		//userService.
		
		return Msg.success();
	}
	
}






