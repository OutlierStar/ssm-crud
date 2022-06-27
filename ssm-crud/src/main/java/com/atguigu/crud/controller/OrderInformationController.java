package com.atguigu.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.OrderInformation;
import com.atguigu.crud.bean.Restaurant;
import com.atguigu.crud.bean.Sort;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.dao.OrderInformationMapper;
import com.atguigu.crud.service.OrderInformationService;
import com.atguigu.crud.service.OrderService;
import com.atguigu.crud.service.RestaurantService;
import com.atguigu.crud.service.SortService;
import com.atguigu.crud.service.UserService;

@RestController
@RequestMapping("/orderInformation")
public class OrderInformationController {
	
	@Autowired
	private OrderInformationService orderInformationService;
	
	@RequestMapping("/get")
	public Msg getOrderInformationByUser(int orderId) {//餐厅登录
		
		List<OrderInformation> list = orderInformationService.getOrderInformationByUser(orderId);
		
		if(list != null && list.size() != 0) {//不为空，则成功
			
			return Msg.success().add("orderInformations", list);
			
		}else {//失败
			
			
			return Msg.fail().add("orderInformations", null);
			
		}
		
	}
//	@RequestMapping("/update")
//	public Msg update(Restaurant restaurant) {//餐厅登录
//		
//		Boolean bool
//		if(restaurant != null) {//不为空，则成功
//			
//			return Msg.success().add("restaurant", restaurant);
//			
//		}else {//失败
//			
//			
//			return Msg.fail().add("restaurant", null);
//			
//		}
//		
//	}
}



