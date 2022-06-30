package com.atguigu.crud.dao;

import com.atguigu.crud.bean.Orders;
import com.atguigu.crud.bean.OrdersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersMapper {
    long countByExample(OrdersExample example);

    int deleteByExample(OrdersExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExample(OrdersExample example);

    Orders selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
    
    List<Orders> selectSortCountGroupByTime();//根据时间分类订单量
    List<Orders> selectSortPriceGroupByTime();//根据时间分类营销额
    Orders selectToDaySortCount();//今日订单量
    Orders selectToDaySortSales();//今日营销额
    Orders countSortSales();//总订单量
    
    
}