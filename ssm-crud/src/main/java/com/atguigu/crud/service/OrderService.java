package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Orders;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.dao.OrdersMapper;

@Service
public class OrderService {

	@Autowired
	private OrdersMapper ordersMapper;
	
	/**
	 * 查询所有订单，返回list
	 * @return
	 */
	public List<Orders> getAllOrders()
	{
		
		return null;
	}
	/**
	 * 
	 * 查询个人的订单，返回list
	 * @param user
	 * @return
	 */
	public List<Orders> getOrdersByUser(User user)
	{
		return null;
		
	}
	/**
	 * 
	 * 修改订单（评论）
	 * @param orders
	 * @return
	 */
	public boolean updateOrders(Orders orders)
	{
		
		return true;
		
	}
	
	/**
	 * 添加订单，返回Boolean
	 * @param orders
	 * @return
	 */
	public boolean insertOrders(Orders orders)
	{
		
		return true;
	}
	
	
	
	
}
