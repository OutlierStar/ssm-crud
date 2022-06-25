package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Sort;
import com.atguigu.crud.dao.SortMapper;

@Service
public class SortService {
	@Autowired
	private SortMapper sortMapper;
	
	/**
	 * 顾客、餐厅使用
	 * 查询所有分类
	 * @return List<Sort>
	 */
	public List<Sort> getAllSort()
	{
		return null;
		
	}
	
	/**
	 * 餐厅使用
	 * 添加分类
	 * @param sort
	 * @return
	 */
	public void insertSort(Sort sort)
	{
	
		
		
	}
	
	/**
	 * 餐厅使用
	 * 删除分类
	 * @param sort
	 * @return 
	 */
	public void deleteSort(Sort sort)
	{
		
		
	}
	
	/**
	 * 餐厅使用
	 * 修改分类
	 * @param sort
	 * @return 
	 */
	public void updateSort(Sort sort)
	{
		
		
	}
	
	
	
}
