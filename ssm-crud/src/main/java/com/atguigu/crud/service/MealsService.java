package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.atguigu.crud.bean.Meals;
import com.atguigu.crud.bean.MealsExample;
import com.atguigu.crud.bean.Sort;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.bean.UserExample;
import com.atguigu.crud.dao.MealsMapper;

@Service
public class MealsService {

	
	@Autowired
	private MealsMapper mealsMapper;
	/**
	 * 顾客、餐厅使用
	 * 根据分类查询菜品 ，返回list
	 * @param sort
	 * @return List<Meals>
	 */
	public List<Meals> getMealsBySort(int sortId)
	{
		
		MealsExample meal = new MealsExample();
		MealsExample.Criteria criteria = meal.createCriteria();
		criteria.andSortIdEqualTo(sortId);
		return mealsMapper.selectByExample(meal);
		
	}
	
	/**
	 * 餐厅使用
	 * 获取所有菜品
	 * @return List<Meals>
	 */
	public List<Meals> getAllMeals()
	{
		
		return mealsMapper.selectByExample(null);
	}
	
	/**
	 * 顾客使用，销量排行
	 * 根据销量排名菜品，返回list
	 * @return List<Meals>
	 */
	public List<Meals> RankMeals()
	{
		
		MealsExample meal = new MealsExample();
		meal.setOrderByClause("meals_Sales desc");
		return mealsMapper.selectByExample(meal);
	}
	
	/**
	 * 餐厅使用
	 * 插入菜品
	 * @param meals
	 * @return boolean
	 */
	public boolean insertMeals(Meals meals)
	{
		meals.setMealsSales(0);
		int flag=mealsMapper.insertSelective(meals);
		if(flag==1)
			return true;
		return false;
	}
	
	/**
	 * 餐厅使用
	 * 删除菜品
	 * @param mealId
	 * @return boolean
	 */
	public boolean deleteMeals(int mealId)
	{
		int flag=mealsMapper.deleteByPrimaryKey(mealId);
		if(flag==1)
			return true;
		return false;
		
	}
	/**
	 * 餐厅使用
	 * 修改菜品
	 * @param meals
	 * @return void
	 */
	public boolean updateMeals(Meals meals)
	{
		int flag=mealsMapper.updateByPrimaryKey(meals);
		if(flag==1)
			return true;
		return false;
	}
	
	
	/**
	 * 通过ID查询菜品
	 * @param mealsId
	 * @return Meals
	 */
	public Meals getMealsById(int mealsId)
	{
		
		return mealsMapper.selectByPrimaryKey(mealsId);
		
	}
	
	
}
