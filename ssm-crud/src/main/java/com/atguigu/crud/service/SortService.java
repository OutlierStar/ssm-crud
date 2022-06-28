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
	public boolean insertSort(Sort sort)
	{
		int flag=sortMapper.insertSelective(sort);
		if(flag==1)
			return true;
		return false;
	}
	
	/**
	 * 餐厅使用
	 * 删除分类
	 * @param sort
	 * @return boolean
	 */
	public boolean deleteSort(int sortId)
	{
		
		int flag=sortMapper.deleteByPrimaryKey(sortId);
		if(flag==1)
			return true;
		return false;
	}
	
	/**
	 * 餐厅使用
	 * 修改分类
	 * @param sort
	 * @return boolean
	 */
	public boolean updateSort(Sort sort)
	{
		int flag=sortMapper.updateByPrimaryKey(sort);
		if(flag==1)
			return true;
		return false;
	}
	

	
}
