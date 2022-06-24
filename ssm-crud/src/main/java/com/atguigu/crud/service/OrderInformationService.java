package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.OrderInformation;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.dao.OrderInformationMapper;

@Service
public class OrderInformationService {
	
	@Autowired
	private OrderInformationMapper orderInformationMapper;
	
	
	/**
	 * 查询所有订单信息
	 * @returnList<OrderInformation>
	 */
	public List<OrderInformation> getAllOrderInformation()
	{
		
		return null;
	}
	/**
	 * 
	 * 查询个人的订单信息
	 * @param user
	 * @return List<OrderInformation>
	 */
	public List<OrderInformation> getOrderInformationByUser(User user)
	{
		return null;
		
	}
	/**
	 * 
	 * 修改订单信息（数量）
	 * @param orders
	 * @return Boolean
	 */
	public boolean updateOrderInformation(OrderInformation orderInformation)
	{
		
		return true;
		
	}
	
	/**
	 * 添加一条订单信息
	 * @param orders
	 * @return Boolean
	 */
	public boolean insertOrderInformation(OrderInformation orderInformation)
	{
		
		return true;
	}
	
}
