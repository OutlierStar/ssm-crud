package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Meals;
import com.atguigu.crud.bean.Sort;
import com.atguigu.crud.dao.MealsMapper;

@Service
public class MealsService {

	
	@Autowired
	private MealsMapper mealsMapper;
	/**
	 * 
	 * 根据分类查询菜品 ，返回list
	 * @param sort
	 * @return
	 */
	public List<Meals> getMealsBySort(Sort sort)
	{
		return null;
	}
	
	/**
	 * 
	 * 获取所有菜品
	 * @return
	 */
	public List<Meals> getAllMeals()
	{
		
		return null;
	}
	/**
	 * 
	 * 插入菜品，返回Boolean
	 * @param meals
	 * @return
	 */
	public boolean insertMeals(Meals meals)
	{
		return true;
		
	}
	
	/**
	 * 删除菜品，返回Boolean
	 * @param meals
	 * @return
	 */
	public boolean deleteMeals(Meals meals)
	{
		return true;
	}
	/**
	 * 修改菜品，返回Boolean
	 * @param meals
	 * @return
	 */
	public boolean updateMeals(Meals meals)
	{
		return true;
	}
	/**
	 * 
	 * 根据销量排名菜品，返回list
	 * @return
	 */
	public List<Meals> RankMeals( )
	{
		return null;
	}
	
}
