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
	 * 添加分类，返回Boolean
	 * @param sort
	 * @return boolean
	 */
	public boolean insertSort(Sort sort)
	{
		return true;
		
		
	}
	
	/**
	 * 餐厅使用
	 * 删除分类，返回Boolean
	 * @param sort
	 * @return boolean
	 */
	public boolean deleteSort(Sort sort)
	{
		
		return true;
	}
	
	/**
	 * 餐厅使用
	 * 修改分类，返回Boolean
	 * @param sort
	 * @return Boolean
	 */
	public boolean updateSort(Sort sort)
	{
		
		return true;
	}
	
	
	
}
