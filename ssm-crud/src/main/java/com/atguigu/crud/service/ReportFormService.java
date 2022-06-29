package com.atguigu.crud.service;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Orders;
import com.atguigu.crud.bean.OrdersExample;
import com.atguigu.crud.dao.OrdersMapper;

@Service
public class ReportFormService {

	@Autowired
	private OrdersMapper ordersMapper;
	
	
	/**
	 * 生成营销额折线图，按时间分类
	 * 
	 */
	public void salesReport()
	{
		
		
		List<Orders> list= ordersMapper.selectSortPriceGroupByTime();
		
		
    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //设置数据	,数值,第几条线,分类
    	
        for(Orders t :list)
        	dataset.addValue( t.getOrderPrice() , "111" , t.getOrderTime() );        
 
    	JFreeChart jfreeChart = ChartFactory.createLineChart("当天营销额折线图","时间","营销额",
    			dataset, PlotOrientation.VERTICAL, true, false,
     			false);
	  	ChartFrame chartFrame = new ChartFrame("标题", jfreeChart);
	  	chartFrame.pack();
	  	chartFrame.setVisible(true);
		
	}
	
	/**
	 * 
	 * 生成订单量折线图，按时间分类
	 */
	public void sortReport()
	{
		
		List<Orders> list= ordersMapper.selectSortCountGroupByTime();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //设置数据	,数值,第几条线,分类
    	
        for(Orders t :list)
        	dataset.addValue( t.getOrderPrice() , "111" , t.getOrderTime() );        
 
    	JFreeChart jfreeChart = ChartFactory.createLineChart("当天订单量折线图","时间","订单量",
    			dataset, PlotOrientation.VERTICAL, true, false,
     			false);
	  	ChartFrame chartFrame = new ChartFrame("标题", jfreeChart);
	  	chartFrame.pack();
	  	chartFrame.setVisible(true);
	  	
	}
	
	
	
	
}
