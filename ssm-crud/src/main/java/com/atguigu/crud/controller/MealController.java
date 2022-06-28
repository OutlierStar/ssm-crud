package com.atguigu.crud.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
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
@CrossOrigin //允许所有ip跨域
public class MealController {
	
	@Autowired
	private MealsService mealsService;
	
	@RequestMapping("/getBySort")
	public Msg getMealsBySort(int sortId) {//根据类型返回菜品
		
		List<Meals> list = mealsService.getMealsBySort(sortId);
		
		if(list != null && list.size()!=0) {//获取成功
			
			return Msg.success().add("meals", list);
			
		}		
		return Msg.fail().add("meals", null); //获取失败
	}
	
	@RequestMapping("/getAll")
	
	public Msg getAllMeals( ) {//返回全部菜品
		
		List<Meals> list = mealsService.getAllMeals();
		
		if(list != null && list.size()!=0) {//获取成功
			
			return Msg.success().add("meals", list);
			
		}		
		return Msg.fail().add("meals", null); //获取失败
	}
	@RequestMapping("/getRank")
	
	public Msg getAllMealsRank() {//返回菜品排名
		
		List<Meals> list = mealsService.RankMeals();
		
		if(list != null && list.size()!=0) {//获取成功
			
			return Msg.success().add("meals", list);
			
		}		
		return Msg.fail().add("meals", null); //获取失败
	}
	
	@RequestMapping("/add")
	public Msg addMeal(@RequestBody Meals meal){//增加菜品
		Boolean bool = mealsService.insertMeals(meal);
		if(bool) {
			
			return Msg.success();
		}
		return Msg.fail();
		
	}
	
	@RequestMapping("/update")
	public Msg updateMeal(@RequestBody Meals meal) {//修改菜品
		Boolean bool = mealsService.updateMeals(meal);
		if(bool) {
			
			return Msg.success();
		}
		return Msg.fail();
	}
	
	@RequestMapping("/delete")
	public Msg deleteMeal(int mealsId) {//删除菜品
		
		Boolean bool = mealsService.deleteMeals(mealsId);
		if(bool) {
			
			return Msg.success();
		}
		return Msg.fail();
		
	}
	
}













