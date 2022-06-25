package com.atguigu.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.ShoppingCart;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.service.ShoppingCartService;


@RestController
@RequestMapping("/shopingCart")
public class ShoppingCartController {
	
	@Autowired
	public ShoppingCartService shoppingCartService;
		
	@RequestMapping("/get")
	public Msg getShoppingCart(User user) {//获取购物车信息
		
		List<ShoppingCart> list = shoppingCartService.getAllShoppingCart(user);
			
		if (list != null) {//成功返回
			
			System.out.println("放回购物车信息成功！");
			return Msg.success().add("ShopingCart", list);
			
		}else {//失败
			
			System.out.println("放回购物车信息失败！");
			return Msg.fail().add("ShopingCart", null);
			
		}
		
	}
	@RequestMapping("/add")
	public Msg addShoppingCart(ShoppingCart shopingCart) {//增加购物车信息
		
		shoppingCartService.insertShoppingCart(shopingCart);
		System.out.println("增加购物车信息成功！");
		return Msg.success();
		
	}
	@RequestMapping("/delete")
	public Msg deleteShoppingCart(ShoppingCart shopingCart) {//删除购物车信息
		
		shoppingCartService.deleteShoppingCart(shopingCart);
		System.out.println("删除购物车信息成功！");
		return Msg.success();
		
	}
	@RequestMapping("/update")
	public Msg updatShoppingCart(ShoppingCart shopingCart) {//修改购物车信息
		
		shoppingCartService.updateShoppingCart(shopingCart);
		System.out.println("修改购物车信息成功！");
		return Msg.success();
		
	}
	@RequestMapping("/submit")
	public Msg submitShopingCart(User user){//提交用户的购物车
		
		shoppingCartService.SubmitShoppingCart(user);
		System.out.println("提交购物车成功！生成订单");
		return Msg.success();
	}
	
}















