package com.atguigu.crud.controller;

import java.net.http.HttpResponse;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.stylesheets.LinkStyle;

import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.service.OrderService;
import com.atguigu.crud.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/loginByCookie")
	public Msg loginByCookie(HttpServletRequest request) {//登录
		
		Cookie[] list = request.getCookies();
		for(int i = 0;i<list.length;i++) {
			if(list[i].getName().equals("userId")) {
				
				User user = userService.getUserById(Integer.parseInt(list[i].getValue()));
				return Msg.success().add("user", user);
	
			}
		} 
		return Msg.fail().add("user", null);
		
	}
	
	@RequestMapping("/login")
	public Msg login(HttpServletResponse response,User user) {//登录
		
		User userRight = userService.login(user.getUserAccount(), user.getUserPassword());
		
		if(userRight != null) {//不为空，则登陆成功
			
			response.addCookie(new Cookie("userId", ""+userRight.getUserId()));
			return Msg.success().add("user", userRight);
			
		}else {//登陆失败
			
			
			return Msg.fail().add("user", null);
			
		}
		
	}
	
	@RequestMapping("/register")
	public Msg register(User user) {//注册
		
		User newUser = userService.insertUser(user);
		if(user!=null) {
			
			return Msg.success().add("user", newUser);
			
		}
		return Msg.fail().add("user", null);
	}
	
	@RequestMapping("/search")
	public Msg search(int userId) {//查询个人信息
		
		User user = userService.getUserById(userId);
		if(user!=null) {
			
			return Msg.success().add("user", user);
			
		}
		return Msg.fail().add("user", null);
		
	}
	
	@RequestMapping("/getAllUsers")
	public Msg getAllUsers( ) {//获取全部用户的信息
		
		List<User> list = userService.getAllUser();
		if(list!=null&&list.size()!=0) {
			
			return Msg.success().add("users", list);
			
		}
		return Msg.fail().add("users", null);
		
	}
	
	@RequestMapping("/changeUser")
	public Msg changeUser( User user) {//修改用户的信息
		
		boolean bool = userService.updateUser(user);
		
		if(bool) {
			return Msg.success();
			
		}
		return Msg.fail();
	}
		
}



