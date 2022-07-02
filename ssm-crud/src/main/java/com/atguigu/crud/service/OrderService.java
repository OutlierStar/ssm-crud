package com.atguigu.crud.service;

import java.util.Date;
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
	 * @return Orders
	 */
	public Orders commentOrder(int orderId,String comment)
	{
		
		Orders o = ordersMapper.selectByPrimaryKey(orderId);
		o.setOrderComment(comment);
		
		ordersMapper.updateByPrimaryKeySelective(o);
		
		return ordersMapper.selectByPrimaryKey(orderId);
	}
	
	/**
	 * 
	 * 添加备注
	 * @param orderId
	 * @param remarks
	 * @return Orders
	 */
	public Orders addOrderRemarks(int orderId,String remarks)
	{
		Orders o = ordersMapper.selectByPrimaryKey(orderId);
		o.setOrderRemarks(remarks);
		
		ordersMapper.updateByPrimaryKeySelective(o);
		
		return ordersMapper.selectByPrimaryKey(orderId);
		
		
	}
	
	
	/**
	 * 修改订单状态
	 * @param orderId
	 * @param status
	 * @return Orders
	 */
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
		order.setOrderByClause("order_Id desc");
		OrdersExample.Criteria criteria = order.createCriteria();
		criteria.andUserIdEqualTo(userId);
		
		return ordersMapper.selectByExample(order).get(0);
		
	}
	

	/**
	 * 
	 * 插入order
	 * @param user
	 * @return Orders
	 */
	public boolean insertOrder(Orders orders)
	{
		
		int bool = ordersMapper.insertSelective(orders);
		if(bool==1) {
			return true;
			
		}
		return false;
		
	}
	
	/**
	 * 修改订单
	 * @param order
	 * @return boolean
	 */
	public boolean updateOrder(Orders order)
	{
		int flag = ordersMapper.updateByPrimaryKey(order);
		if(flag==1) {
			return true;
		}
		return false;
		
	}
	
	/**
	 * 通过订单ID获取订单
	 * @param orderId
	 * @return
	 */
	public Orders getOrderByOrderId(int orderId)
	{
		return ordersMapper.selectByPrimaryKey(orderId);
		
	}
	
	/***
	 * 设置付款时间
	 * @param orderId
	 * @return boolean
	 */
	public boolean setPayTime(int orderId)
	{
		Orders t=getOrderByOrderId(orderId);
		t.setOrderPayment(new Date());
		updateOrder(t);
		return true;
		
	}
	/**
	 * 设置完成时间
	 * @param orderId
	 * @return boolean
	 */
	public boolean setFinishTime(int orderId)
	{
		
		Orders t=getOrderByOrderId(orderId);
		t.setOrderFinish(new Date());
		updateOrder(t);
		return true;
		
	}
	
	
	
	/**
	 * 
	 * 添加桌号
	 * @param orderId
	 * @param table
	 * @return
	 */
	public boolean addOrderTable(int orderId,int table)
	{
		Orders t=getOrderByOrderId(orderId);
		t.setOrderTable(table);
		updateOrder(t);
		return true;
		
		
	}
	
	
}
