package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.ShoppingCart;
import com.atguigu.crud.dao.ShoppingCartMapper;

@Service
public class ShoppingCartService {
	@Autowired
	private ShoppingCartMapper shoppingCartMapper;
	/**
	 * 
	 * 添加菜品，加入购物车,返回Boolean
	 * @param shoppingcart
	 * @return
	 */
	public boolean insertShoppingCart(ShoppingCart shoppingcart)
	{
		
		return true;
	}
	
	/**
	 * 
	 * 查询购物车,返回list
	 * @return
	 */
	public List<ShoppingCart> getAllShoppingCart()
	{
		
		return null;
	}
	
	/**
	 * 
	 * 删除购物车，返回Boolean
	 * @param shoppingcart
	 * @return
	 */
	public boolean deleteShoppingCart(ShoppingCart shoppingcart)
	{
		
		return true;
		
	}
	
	/**
	 * 
	 * 修改购物车中菜品的信息，返回Boolean
	 * @param shoppingcart
	 * @return
	 */
	public boolean updateShoppingCart(ShoppingCart shoppingcart)
	{
		
		return true;
		
	}
	/**
	 * 
	 * 提交购物车,返回Boolean
	 * @return
	 */
	public boolean SubmitShoppingCart()
	{
		
		return true;
	}
	
}
