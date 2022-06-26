package com.atguigu.crud.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.OrderInformation;
import com.atguigu.crud.bean.Orders;
import com.atguigu.crud.bean.ShoppingCart;
import com.atguigu.crud.bean.ShoppingCartExample;
import com.atguigu.crud.bean.ShoppingCartKey;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.bean.UserExample;
import com.atguigu.crud.dao.OrderInformationMapper;
import com.atguigu.crud.dao.OrdersMapper;
import com.atguigu.crud.dao.ShoppingCartMapper;

@Service
public class ShoppingCartService {
	@Autowired
	private ShoppingCartMapper shoppingCartMapper;
	private OrdersMapper ordersMapper;
	private OrderService orderService;
	private OrderInformationMapper orderInformationMapper;
	/**
	 * 顾客使用
	 * 添加菜品，加入购物车
	 * @param shoppingcart
	 * @return 
	 */
	public boolean insertShoppingCart(ShoppingCart shoppingcart)
	{
		
		int flag=shoppingCartMapper.insertSelective(shoppingcart);
		
		if(flag==1)
			return true;
		return false;
	}
	/**
	 * 顾客使用
	 * 查询个人购物车
	 * @param user
	 * @return List<ShoppingCart>
	 */
	public List<ShoppingCart> getAllShoppingCart(int userId)
	{
		
		ShoppingCartExample shop = new ShoppingCartExample();
		  
		ShoppingCartExample.Criteria criteria = shop.createCriteria(); //构造自定义查询条件
	    criteria.andUserIdEqualTo(userId);
	         
	    List<ShoppingCart> t = shoppingCartMapper.selectByExample(shop);
	      
	    return t;
		
	}
	
	/**
	 * 顾客使用
	 * 删除购物车
	 * @param shoppingcart
	 * @return boolean
	 */
	public boolean deleteShoppingCart(ShoppingCartKey key)
	{
		ShoppingCart s = new ShoppingCart();
		s.setUserId(key.getUserId());
		s.setMealsId(key.getMealsId());
		
		int flag=shoppingCartMapper.deleteByPrimaryKey(s);
		if(flag==1)
			return true;
		return false;
		
	}
	
	/**
	 * 顾客使用
	 * 修改购物车中菜品的信息
	 * @param shoppingcart
	 * @return boolean 
	 */
	public boolean updateShoppingCart(ShoppingCart shoppingcart)
	{
		
		int flag=shoppingCartMapper.updateByPrimaryKeySelective(shoppingcart);
		if(flag==1)
			return true;
		return false;
	}
	
	
	/**
	 * 顾客使用
	 * 提交购物车，插入订单表->获取订单号->插入订单信息表
	 * @return 
	 */
	public Orders SubmitShoppingCart(int userId)
	{
		
		
		List<ShoppingCart> list=getAllShoppingCart(userId);
		Orders order=new Orders();
		
		order.setOrderId(userId);
		
		ordersMapper.insert(order);
		
		int orderId=orderService.selectOrderId(userId).getOrderId();
		
		
		for(ShoppingCart t:list) {
			
			
			OrderInformation oi= new OrderInformation();
			oi.setMealsId(t.getMealsId());
			oi.setMealsNum(t.getMealsNum());
			oi.setOrderId(orderId);
			
			orderInformationMapper.insert(oi);
			
		}
		
		return orderService.selectOrderId(userId);
			
	}
	
}
