package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Orders;
import com.atguigu.crud.bean.OrdersExample;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.bean.UserExample;
import com.atguigu.crud.controller.ordersController;
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
		return ordersMapper.selectByExample(null);
	}
	/**
	 * 顾客使用
	 * 查询个人的订单
	 * @param user
	 * @return List<Orders>
	 */
	public List<Orders> getOrdersByUser(int userId)
	{
		
		
		OrdersExample order = new OrdersExample();
		OrdersExample.Criteria criteria = order.createCriteria();
		criteria.andUserIdEqualTo(userId);
		
		return ordersMapper.selectByExample(order);
		
	}
	/**
	 * 顾客使用
	 * 修改订单（评论）
	 * @param orders
	 * @return 
	 */
	public Orders commentOrder(int orderId,String comment)
	{
		
		Orders o = ordersMapper.selectByPrimaryKey(orderId);
		o.setOrderComment(comment);
		
		ordersMapper.updateByPrimaryKeySelective(o);
		
		return ordersMapper.selectByPrimaryKey(orderId);
	}
	
	
	public Orders alterOrderStatus(int orderId,int status)
	{
		
		Orders o = ordersMapper.selectByPrimaryKey(orderId);
		o.setOrderStatus(status);
		
		ordersMapper.updateByPrimaryKeySelective(o);
		
		return ordersMapper.selectByPrimaryKey(orderId);
		
	}
	
	
	
	
	/**
	 * 
	 * 结算的时候，查询最大Order号
	 * @param user
	 * @return Orders
	 */
	public Orders selectOrderId(int userId)
	{
		
		OrdersExample order = new OrdersExample();
		order.setOrderByClause("orderId desc");
		OrdersExample.Criteria criteria = order.createCriteria();
		criteria.andUserIdEqualTo(userId);
		
		return ordersMapper.selectByExample(order).get(0);
		
	}
	

	
	
	
}
