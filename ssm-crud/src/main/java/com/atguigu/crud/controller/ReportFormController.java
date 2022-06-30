package com.atguigu.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.crud.service.ReportFormService;

@RestController
@RequestMapping("/123")
@CrossOrigin //允许所有ip跨域
public class ReportFormController {

	@Autowired
	private ReportFormService reportFormService;
	
	
	
	@RequestMapping("/test")
	public void test()
	{
		reportFormService.sortCountReport();
		reportFormService.salesCountReport();
		
		System.out.println("今日营销额："+reportFormService.getToDaySalesCount());
		System.out.println("今日订单量："+reportFormService.getToDayOrderCount());
		System.out.println("总营销额："+reportFormService.getAllSalesCount());
		System.out.println("总订单量："+reportFormService.getAllOrderCount());
	}
	
	
}
