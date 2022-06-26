package com.atguigu.crud.controller;

import java.util.List;

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
		
		User userRight = userService.login(user.getUserAccount(), user.getUserPassword());
		
		if(userRight != null) {//不为空，则登陆成功
			
			return Msg.success().add("user", userRight);
			
		}else {//登陆失败
			
			
			return Msg.fail().add("user", null);
			
		}
		
	}
	
	@RequestMapping("/register")
	public Msg register(User user) {//注册
		
		User newUser = userService.insertUser(user);
		if(user!=null) {
			
			return Msg.success().add("newUser", newUser);
			
		}
		return Msg.fail().add("newUser", null);
	}
	
	@RequestMapping("/search")
	public Msg search(int userId) {//查询个人信息
		
		User user = userService.getUserById(userId);
		if(user!=null) {
			
			return Msg.success().add("userInform", user);
			
		}
		return Msg.fail().add("userInform", null);
		
	}
	
	@RequestMapping("/getAllUsers")
	public Msg getAllUsers( ) {//获取全部用户的信息
		
		List<User> list = userService.getAllUser();
		if(list!=null&&list.size()!=0) {
			
			return Msg.success().add("allUsers", list);
			
		}
		return Msg.fail().add("allUsers", null);
		
	}
	
	@RequestMapping("/changeUser")
	public Msg changeUser( User user) {//获取全部用户的信息
		
		boolean bool = userService.updateUser(user);
		
		if(bool) {
			return Msg.success();
			
		}
		return Msg.fail();
	}
		
}



