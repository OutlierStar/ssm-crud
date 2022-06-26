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
	
	@RequestMapping("/getByUserId")
	public Msg getAllOrdersByUserId(int userId) {//根据用户信息返回全部订单信息
		
	
		List<Orders> list = orderService.getOrdersByUser(userId);
		
		if(list != null&&list.size()!=0) {//获取成功
			
			return Msg.success().add("OrderList", list);
			
		}		
		return Msg.fail().add("OrderList" , null); //获取失败
	}
	
	@RequestMapping("/getall")
	public Msg getAllOrders() {//根据用户信息返回全部订单信息
		
	
		List<Orders> list = orderService.getAllOrders();
		
		if(list != null&&list.size()!=0) {//获取成功
			
			return Msg.success().add("allList", list);
			
		}		
		return Msg.fail().add("allList" , null); //获取失败
	}
	
	@RequestMapping("/changeStatus")
	public Msg changeOrderStatus(int orderId,int status){//修改状态
		
		Orders neworder = orderService.alterOrderStatus(orderId,status);
		if(neworder!=null) {
			
			return Msg.success().add("newOrder", neworder);
		}
		return Msg.fail().add("newOrder", null);
		
	}
	
	@RequestMapping("/addComments")
	public Msg addOrderComments(int orderId,String order_comment) {//增加评论
		
		Orders neworder = orderService.commentOrder(orderId,order_comment);
		if(neworder!=null) {
			
			return Msg.success().add("newOrder", neworder);
		}
		return Msg.fail().add("newOrder", null);
		
	}
}

