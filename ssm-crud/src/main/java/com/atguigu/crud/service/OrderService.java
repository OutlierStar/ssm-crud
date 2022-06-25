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
	 * 查询个人的订单，返回list
	 * @param user
	 * @return List<Orders>
	 */
	public List<Orders> getOrdersByUser(User user)
	{
		
		
		OrdersExample order = new OrdersExample();
		OrdersExample.Criteria criteria = order.createCriteria();
		criteria.andUserIdEqualTo(user.getUserId());
		
		return ordersMapper.selectByExample(order);
		
	}
	/**
	 * 顾客使用
	 * 修改订单（评论）
	 * @param orders
	 * @return 
	 */
	public void updateOrders(Orders orders)
	{
		
		ordersMapper.updateByPrimaryKeySelective(orders);
		
	}
	
	/**
	 * 顾客提交购物车时使用
	 * 添加订单
	 * @param orders
	 * @return 
	 */
	public void insertOrders(Orders orders)
	{
		ordersMapper.insertSelective(orders);
		
	}
	
	
	
	
}
