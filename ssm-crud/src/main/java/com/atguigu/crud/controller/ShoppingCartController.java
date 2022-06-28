package com.atguigu.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.Orders;
import com.atguigu.crud.bean.ShoppingCart;
import com.atguigu.crud.bean.ShoppingCartKey;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.service.ShoppingCartService;


@RestController
@RequestMapping("/shopingCart")
@CrossOrigin //允许所有ip跨域
public class ShoppingCartController {
	
	@Autowired
	public ShoppingCartService shoppingCartService;
		
	@RequestMapping("/get")
	public Msg getShoppingCart(int userId) {//获取购物车信息
		
		List<ShoppingCart> list = shoppingCartService.getAllShoppingCart(userId);
		float sum = shoppingCartService.getShoppingCartPrice(userId);
		if (list != null&&list.size()!=0) {//成功返回
			
			System.out.println("放回购物车信息成功！");
			return Msg.success().add("shopingCart", list).add("price", sum);
		}else {//失败
			
			System.out.println("放回购物车信息失败！");
			return Msg.fail().add("shopingCart", null).add("price", sum);
			
		}
		
	}
	@RequestMapping("/add")
	public Msg addShoppingCart(@RequestBody ShoppingCart shopingCart) {//增加购物车信息
		
		Boolean bool= shoppingCartService.insertShoppingCart(shopingCart);
		float sum = shoppingCartService.getShoppingCartPrice(shopingCart.getUserId());
		if(bool) {
			return Msg.success().add("price", sum);
		}
		return Msg.fail().add("price", sum);
		
	}
	@RequestMapping("/delete")
	public Msg deleteShoppingCart(@RequestBody ShoppingCartKey shopingCartKey) {//删除购物车信息
		
		Boolean bool= shoppingCartService.deleteShoppingCart(shopingCartKey);
		float sum = shoppingCartService.getShoppingCartPrice(shopingCartKey.getUserId());
		if(bool) {
			return Msg.success().add("price", sum);
		}
		return Msg.fail().add("price", sum);
		
	}
	@RequestMapping("/update")
	public Msg updatShoppingCart(@RequestBody ShoppingCart shopingCart) {//修改购物车信息
		
		Boolean bool= shoppingCartService.updateShoppingCart(shopingCart);
		float sum = shoppingCartService.getShoppingCartPrice(shopingCart.getUserId());
		if(bool) {
			return Msg.success().add("price", sum);
		}
		return Msg.fail().add("price", sum);
		
	}
	@RequestMapping("/submit")
	public Msg submitShopingCart(int userId){//提交用户的购物车
		
		Orders order = shoppingCartService.SubmitShoppingCart(userId);
		float sum = shoppingCartService.getShoppingCartPrice(userId);
		if(order!=null) {
			
			return Msg.success().add("order", order).add("price", sum);
		}
		
		return Msg.fail().add("order", null).add("price", sum);
	}
	
}















