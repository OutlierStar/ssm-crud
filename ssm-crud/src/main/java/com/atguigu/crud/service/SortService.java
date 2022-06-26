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
		return sortMapper.selectByExample(null);
		
	}
	
	/**
	 * 餐厅使用
	 * 添加分类
	 * @param sort
	 * @return
	 */
	public void insertSort(Sort sort)
	{
	
		sortMapper.insertSelective(sort);
		
	}
	
	/**
	 * 餐厅使用
	 * 删除分类
	 * @param sort
	 * @return 
	 */
	public void deleteSort(Sort sort)
	{
		
		sortMapper.deleteByPrimaryKey(sort.getSortId());
	}
	
	/**
	 * 餐厅使用
	 * 修改分类
	 * @param sort
	 * @return 
	 */
	public void updateSort(Sort sort)
	{
		sortMapper.updateByPrimaryKey(sort);
		
	}
	
	/**
	 * 
	 * 通过ID获取菜品
	 * @param id
	 * @return Sort
	 */
	public Sort getSortById(int id)
	{
		
		return sortMapper.selectByPrimaryKey(id);
	}
	
	
}
