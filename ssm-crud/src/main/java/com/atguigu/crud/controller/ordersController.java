package com.atguigu.crud.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.Orders;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.dao.OrdersMapper;
import com.atguigu.crud.service.OrderService;
import com.atguigu.crud.service.UserService;

@RestController
@RequestMapping("/order")
public class ordersController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/get")
	public Msg getAllOrders(User user) {//根据用户信息返回全部订单信息
		
		List<Orders> list = orderService.getOrdersByUser(user);
		
		if(list != null ) {//获取成功
			
			return Msg.success().add("OrderList", list);
			
		}		
		return Msg.fail().add("OrderList" , null); //获取失败
	}
	
	@RequestMapping("/cancel")
	public Msg cancelOrder(Orders order){//取消订单
		
		orderService.updateOrders(order);
		
		return Msg.success();
		
	}
	
	
}













