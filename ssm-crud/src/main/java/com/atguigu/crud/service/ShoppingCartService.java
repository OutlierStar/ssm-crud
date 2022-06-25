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
import com.atguigu.crud.bean.User;
import com.atguigu.crud.bean.UserExample;
import com.atguigu.crud.dao.OrderInformationMapper;
import com.atguigu.crud.dao.OrdersMapper;
import com.atguigu.crud.dao.ShoppingCartMapper;

@Service
public class ShoppingCartService {
	@Autowired
	private ShoppingCartMapper shoppingCartMapper;
	/**
	 * 顾客使用
	 * 添加菜品，加入购物车
	 * @param shoppingcart
	 * @return 
	 */
	public void insertShoppingCart(ShoppingCart shoppingcart)
	{
		
		shoppingCartMapper.insertSelective(shoppingcart);
	}
	/**
	 * 顾客使用
	 * 查询个人购物车
	 * @param user
	 * @return List<ShoppingCart>
	 */
	public List<ShoppingCart> getAllShoppingCart(User user)
	{
		
		ShoppingCartExample shop = new ShoppingCartExample();
		  
		ShoppingCartExample.Criteria criteria = shop.createCriteria(); //构造自定义查询条件
	     criteria.andUserIdEqualTo(user.getUserId());
	         
	 
	      List<ShoppingCart> t = shoppingCartMapper.selectByExample(shop);
	      
	      return t;
		
		
	}
	
	/**
	 * 顾客使用
	 * 删除购物车
	 * @param shoppingcart
	 * @return 
	 */
	public void deleteShoppingCart(ShoppingCart shoppingcart)
	{
		
		shoppingCartMapper.deleteByPrimaryKey(shoppingcart);
		
		
	}
	
	/**
	 * 顾客使用
	 * 修改购物车中菜品的信息
	 * @param shoppingcart
	 * @return 
	 */
	public void updateShoppingCart(ShoppingCart shoppingcart)
	{
		
		shoppingCartMapper.updateByPrimaryKeySelective(shoppingcart);
		
	}
	/**
	 * 顾客使用
	 * 提交购物车
	 * @return 
	 */
	public void SubmitShoppingCart(User user)
	{
		
		OrdersMapper ordersMapper;
		OrderService orderService;
		OrderInformationMapper orderInformationMapper;
		List<ShoppingCart> list=getAllShoppingCart(user);
		
		//List<Orders> orderlist= new ArrayList<Orders>();
		
		for(ShoppingCart t:list) {
			
			Orders od = new Orders();
			od.setUserId(t.getUserId());
			od.setOrderTime(new Date());
			od.setOrderStatus(0);//未上菜
			
			ordersMapper.insertSelective(od);
			
			
			Orders test = orderService.seletOrderId(user);
			
			OrderInformation oi= new OrderInformation();
			oi.setMealsId(t.getMealsId());
			oi.setMealsNum(t.getMealsNum());
			oi.setOrderId(test.getOrderId());
			
			
		}
		
		
		
		
		
		
	}
	
}
