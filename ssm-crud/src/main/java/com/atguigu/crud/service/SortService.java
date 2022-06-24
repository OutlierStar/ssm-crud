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
	 * 
	 * 查询所有分类,返回list
	 * @return List
	 */
	public List<Sort> getAllSort()
	{
		return null;
		
	}
	
	/**
	 * 添加分类，返回Boolean
	 * @param sort
	 * @return
	 */
	public boolean insertSort(Sort sort)
	{
		return true;
		
		
	}
	
	/**
	 * 
	 * 删除分类，返回Boolean
	 * @param sort
	 * @return
	 */
	public boolean deleteSort(Sort sort)
	{
		
		return true;
	}
	
	/**
	 * 
	 * 修改分类，返回Boolean
	 * @param sort
	 * @return
	 */
	public boolean updateSort(Sort sort)
	{
		
		return true;
	}
	
	
	
}
