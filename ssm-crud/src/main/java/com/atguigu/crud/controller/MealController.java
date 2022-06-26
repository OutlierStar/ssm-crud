package com.atguigu.crud.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.crud.bean.Meals;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.Orders;
import com.atguigu.crud.bean.Sort;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.dao.OrdersMapper;
import com.atguigu.crud.service.MealsService;
import com.atguigu.crud.service.OrderService;
import com.atguigu.crud.service.UserService;

@RestController
@RequestMapping("/meal")
public class MealController {
	
	@Autowired
	private MealsService mealsService;
	
	@RequestMapping("/get")
	public Msg getMealByType(Sort sort) {//根据类型返回菜品
		
		List<Meals> list = mealsService.getMealsBySort(sort);
		
		if(list != null && list.size()!=0) {//获取成功
			
			return Msg.success().add("mealList", list);
			
		}		
		return Msg.fail().add("mealList", null); //获取失败
	}
	
	@RequestMapping("/add")
	public Msg addMeal(Meals meal){//增加菜品
		
		mealsService.insertMeals(meal);
		
		return Msg.success();
		
	}
	
	@RequestMapping("/update")
	public Msg updateMeal(Meals meal) {//修改菜品
		mealsService.updateMeals(meal);
		return Msg.success();
	}
	
	@RequestMapping("/delete")
	public Msg deleteMeal(Meals meal) {//删除菜品
		
		mealsService.deleteMeals(meal);
		return Msg.success();
		
	}
	
}













