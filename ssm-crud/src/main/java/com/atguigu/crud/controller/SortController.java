package com.atguigu.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.Sort;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.service.OrderService;
import com.atguigu.crud.service.SortService;
import com.atguigu.crud.service.UserService;

@RestController
@RequestMapping("/sort")
public class SortController {
	
	@Autowired
	private SortService sortService;
	
	@RequestMapping("/select")
	public Msg selectAll() {//获取全部分类信息
		
		List<Sort> list = sortService.getAllSort();
		
		if(list != null && list.size() != 0) {//不为空，则成功
			
			return Msg.success().add("sorts", list);
			
		}else {//失败
			
			return Msg.fail().add("sorts", null);
			
		}
		
	}
	
	@RequestMapping("/add")
	public Msg addSort(@RequestBody Sort sort) {//增加分类
		
		Boolean bool  = sortService.insertSort(sort);
		if(bool) {
			
			return Msg.success();
			
		}
		return Msg.fail();
	}
	
	@RequestMapping("/delete")
	public Msg deleteSort(int sortId) {//删除分类
		
		Boolean bool = sortService.deleteSort(sortId);
		if(bool) {
			
			return Msg.success();
			
		}
		return Msg.fail();
		
	}
	
	@RequestMapping("/update")
	public Msg updateSort(@RequestBody Sort sort) {//更新分类
		
		Boolean bool = sortService.updateSort(sort);
		if(bool) {
			
			return Msg.success();
			
		}
		return Msg.fail();
	}
	
		
}



