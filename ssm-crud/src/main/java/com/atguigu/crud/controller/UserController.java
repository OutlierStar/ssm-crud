package com.atguigu.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atguigu.crud.bean.Department;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.dao.UserMapper;
import com.atguigu.crud.service.UserService;

@Controller
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping("/emps")	
	public void  getDepts(){
			List<User> list = userService.getAllUser();
		for(User t:list)
			System.out.println(t.getUserName());
	}
	
	
	
}
