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
	 * 餐厅使用
	 * 查询所有订单，返回list
	 * @return List<Orders>
	 */
	public List<Orders> getAllOrders()
	{
		
		return null;
	}
	/**
	 * 顾客使用
	 * 查询个人的订单，返回list
	 * @param user
	 * @return List<Orders>
	 */
	public List<Orders> getOrdersByUser(User user)
	{
		return null;
		
	}
	/**
	 * 顾客使用
	 * 修改订单（评论）
	 * @param orders
	 * @return boolean 
	 */
	public boolean updateOrders(Orders orders)
	{
		
		return true;
		
	}
	
	/**
	 * 顾客提交购物车时使用
	 * 添加订单，返回Boolean
	 * @param orders
	 * @return boolean
	 */
	public boolean insertOrders(Orders orders)
	{
		
		return true;
	}
	
	
	
	
}
