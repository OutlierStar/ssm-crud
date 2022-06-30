package com.atguigu.crud.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
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
	public void salesCountReport()
	{
		
		
		
		List<Orders> list= ordersMapper.selectSortPriceGroupByTime();
		
		
    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //设置数据	,数值,第几条线,分类
    	SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd");
    	
        for(Orders t :list)
        	dataset.addValue( t.getOrderPrice() , "营销额" , sdf.format(t.getOrderFinish()) );        

    	JFreeChart jfreeChart = ChartFactory.createLineChart("当天营销额折线图","时间","营销额",
    			dataset, PlotOrientation.VERTICAL, true, false,
     			false);
    	
    	

    	
        CategoryPlot plot = jfreeChart.getCategoryPlot(); 

    	 LineAndShapeRenderer renderer  =  (LineAndShapeRenderer)plot.getRenderer();
         DecimalFormat decimalformat1  =   new  DecimalFormat( " ##.## " ); // 数据点显示数据值的格式
         renderer.setItemLabelGenerator( new  StandardCategoryItemLabelGenerator( " {2} " , decimalformat1));
                                            // 上面这句是设置数据项标签的生成器
         renderer.setItemLabelsVisible( true ); // 设置项标签显示
         renderer.setBaseItemLabelsVisible( true ); // 基本项标签显示
        
//     	int width = 640; /* Width of the image */
//       int height = 480; /* Height of the image */ 
//       File pieChart = new File( "src//main//webapp//img//2.png" ); 
//       try {
// 			ChartUtilities.saveChartAsPNG( pieChart , jfreeChart , width , height );
// 		} catch (IOException e) {
// 			// TODO Auto-generated catch block
// 			e.printStackTrace();
// 		}
	  	ChartFrame chartFrame = new ChartFrame("标题", jfreeChart);
	  	chartFrame.pack();
	  	chartFrame.setVisible(true);
		
	}
	
	/**
	 * 
	 * 生成订单量折线图，按时间分类
	 */
	public void sortCountReport()
	{
		
		List<Orders> list= ordersMapper.selectSortCountGroupByTime();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //设置数据	,数值,第几条线,分类
		SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd");
    	
        for(Orders t :list)
        	dataset.addValue( t.getOrderPrice() , "订单量" , sdf.format(t.getOrderFinish()) );        
 
    	JFreeChart jfreeChart = ChartFactory.createLineChart("当天订单量折线图","时间","订单量",
    			dataset, PlotOrientation.VERTICAL, true, false,
     			false);
    	

    	CategoryPlot plot = jfreeChart.getCategoryPlot(); 

   	 LineAndShapeRenderer renderer  =  (LineAndShapeRenderer)plot.getRenderer();
        DecimalFormat decimalformat1  =   new  DecimalFormat( " ##.## " ); // 数据点显示数据值的格式
        renderer.setItemLabelGenerator( new  StandardCategoryItemLabelGenerator( " {2} " , decimalformat1));
                                           // 上面这句是设置数据项标签的生成器
        renderer.setItemLabelsVisible( true ); // 设置项标签显示
        renderer.setBaseItemLabelsVisible( true ); // 基本项标签显示
       
    	
        
//      int width = 640; /* Width of the image */
//      int height = 480; /* Height of the image */ 
//      File pieChart = new File( "src//main//webapp//img//2.png" ); 
//      try {
//			ChartUtilities.saveChartAsPNG( pieChart , jfreeChart , width , height );
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
	  	ChartFrame chartFrame = new ChartFrame("标题", jfreeChart);
	  	chartFrame.pack();
	  	chartFrame.setVisible(true);
	  	
	}
	
	/**
	 * 获取今日订单总量
	 * @return int
	 */
	public int getToDayOrderCount()
	{
		
		
		return ordersMapper.selectToDaySortCount().getOrderId();
		
	}
	
	
	/**
	 * 
	 * 获取今日营销额
	 * @return float
	 */
	public float getToDaySalesCount()
	{

		return ordersMapper.selectToDaySortSales().getOrderPrice();
		
	}
	
	/**
	 * 
	 * 获取订单总量
	 * @return int
	 */
	public int getAllOrderCount()
	{
		
		return (int) ordersMapper.countByExample(null);
		
	}
	
	/**
	 * 
	 * 获取总营销额
	 * @return float
	 */
	public float getAllSalesCount()
	{
		
		return ordersMapper.countSortSales().getOrderPrice();
		
	}
	
	
	
	
	
}
