package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.OrderInformation;
import com.atguigu.crud.bean.OrderInformationExample;
import com.atguigu.crud.bean.Orders;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.bean.UserExample;
import com.atguigu.crud.dao.OrderInformationMapper;

@Service
public class OrderInformationService {
	
	@Autowired
	private OrderInformationMapper orderInformationMapper;
	
	
	/**
	 * 餐厅使用
	 * 查询所有订单信息
	 * @return List<OrderInformation>
	 */
	public List<OrderInformation> getAllOrderInformation()
	{
		
		return orderInformationMapper.selectByExample(null);
		
	}
	/**
	 * 
	 * 查询订单信息
	 * @param order
	 * @return
	 */
	public List<OrderInformation> getOrderInformationByUser(Orders order)
	{
		
		
		OrderInformationExample or = new OrderInformationExample();
		OrderInformationExample.Criteria criteria = or.createCriteria();
		criteria.andOrderIdEqualTo(order.getOrderId());
		
		return orderInformationMapper.selectByExample(or);
		
	}
	/**
	 * 顾客使用
	 * 修改订单信息（数量）
	 * @param orders
	 * @return 
	 */
	public void updateOrderInformation(OrderInformation orderInformation)
	{
		
		orderInformationMapper.updateByPrimaryKeySelective(orderInformation);
		
		
	}
	
	/**
	 * 顾客提交购物车时使用
	 * 添加一条订单信息
	 * @param orders
	 * @return 
	 */
	public void insertOrderInformation(OrderInformation orderInformation)
	{
		orderInformationMapper.insertSelective(orderInformation);
		
	}
	
}
