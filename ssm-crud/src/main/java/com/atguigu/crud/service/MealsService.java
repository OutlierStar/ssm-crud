package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Meals> getMealsBySort(Sort sort)
	{
		
		MealsExample meal = new MealsExample();
		MealsExample.Criteria criteria = meal.createCriteria();
		criteria.andSortIdEqualTo(sort.getSortId());
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
	 * 餐厅使用
	 * 插入菜品
	 * @param meals
	 * @return 
	 */
	public void insertMeals(Meals meals)
	{
		
		mealsMapper.insertSelective(meals);
	}
	
	/**
	 * 餐厅使用
	 * 删除菜品
	 * @param meals
	 * @return 
	 */
	public void deleteMeals(Meals meals)
	{
		mealsMapper.deleteByPrimaryKey(meals.getMealsId());
	}
	/**
	 * 餐厅使用
	 * 修改菜品
	 * @param meals
	 * @return void
	 */
	public void updateMeals(Meals meals)
	{
		mealsMapper.updateByPrimaryKey(meals);
	}
	/**
	 * 顾客使用，销量排行
	 * 根据销量排名菜品，返回list
	 * @return List<Meals>
	 */
	public List<Meals> RankMeals( )
	{
		MealsExample meal = new MealsExample();
		meal.setOrderByClause("mealsSales desc");
		
		return mealsMapper.selectByExample(meal);
	}
	
	/**
	 * 通过ID查菜品
	 * @param id
	 * @return Meals
	 */
	public Meals getMealById(int id)
	{
		return mealsMapper.selectByPrimaryKey(id);
		
	}
	
	
}
