package com.atguigu.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.ShoppingCart;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.service.ShoppingCartService;

@Controller
public class ShoppingCartController {
	
	@Autowired
	public ShoppingCartService shoppingCartService;
		
	
	public Msg getOrderMsg(User user) {
		
		List<ShoppingCart> list = shoppingCartService.getAllShoppingCart(User user){
			
			
			
		}
		
		
	}
		
	
	
	
}
