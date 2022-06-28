package com.atguigu.crud.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Meals;
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
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderInformationMapper orderInformationMapper;
	@Autowired
	private MealsService mealsService;
	
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
	 * 提交购物车。插入订单表->获取订单号->销量+1->插入订单信息表->删除购物车->更新订单总价
	 * @return 
	 */
	public Orders SubmitShoppingCart(int userId)
	{
		
		float sumPrice=0;
		
		List<ShoppingCart> list=getAllShoppingCart(userId);
		Orders order=new Orders();
		
		order.setUserId(userId);
		
		orderService.insertOrder(order);
		
		int orderId=orderService.selectOrderId(userId).getOrderId();
		
		
		
		for(ShoppingCart t:list) {
			
			int mealId=t.getMealsId();
			sumPrice += mealsService.getMealsById(mealId).getMealsPrice();
			
			
			Meals meal = mealsService.getMealsById(mealId);
			meal.setMealsSales(meal.getMealsSales()+t.getMealsNum());
			mealsService.updateMeals(meal);
			
			OrderInformation oi= new OrderInformation();
			oi.setMealsId(t.getMealsId());
			oi.setMealsNum(t.getMealsNum());
			oi.setOrderId(orderId);
			
			orderInformationMapper.insert(oi);
			
			ShoppingCartKey key = new ShoppingCartKey();
			key.setUserId(t.getUserId());
			key.setMealsId(t.getMealsId());
			shoppingCartMapper.deleteByPrimaryKey(key);
			
		}
		
		order = orderService.selectOrderId(userId);
		
		order.setOrderPrice(sumPrice);
		orderService.updateOrder(order);
		
		return orderService.selectOrderId(userId);
		
	}
	
	
	/**
	 * 查询购物车总价
	 * 
	 * @param shop
	 * @return float
	 */
	public float getShoppingCartPrice(int userId)
	{
		float price=0;
		List<ShoppingCart> list = getAllShoppingCart(userId);
		for(ShoppingCart t :list)
		{
			int mealId=t.getMealsId();
			price+=mealsService.getMealsById(mealId).getMealsPrice()*t.getMealsNum();
			
			
		}
		return price;
		
	}
	
	
}
