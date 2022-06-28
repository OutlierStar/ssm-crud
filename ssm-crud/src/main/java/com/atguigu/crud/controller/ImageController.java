package com.atguigu.crud.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.crud.bean.ImageFile;
import com.atguigu.crud.bean.Meals;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.Orders;
import com.atguigu.crud.bean.Sort;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.dao.OrdersMapper;
import com.atguigu.crud.service.MealsService;
import com.atguigu.crud.service.OrderService;
import com.atguigu.crud.service.UserService;

@RestController
@RequestMapping("/image")
@CrossOrigin //允许所有ip跨域
public class ImageController {
	
		@RequestMapping("/set") 
		public Msg upload(ImageFile file,int mealsId) throws IllegalStateException, IOException{ 
			// 获取随机文件名 
			//RandomStringUtils类导入jar包位置 https://mvnrepository.com/artifact/org.apache.struts.xwork/xwork-core/2.2.1
			String name = "meals"+mealsId;
			// 获取原有文件名称（包括文件类型） 
			String fileName = file.getImage().getOriginalFilename(); 
			// 截取文件类型 
			int indexdot = fileName.indexOf("."); 
			String suffix = fileName.substring(indexdot); 
			// 创建文件，给文件起名字 
			String newFileName = name + suffix; 
			// 创建 File 对象，并设定存放位置和存放文件的文件名 
			File newFile = new File(ImageController.class.getClassLoader().getResource("/image").getPath(),newFileName); // 调用 newFile 这个实例的 getParentFile 方法， 返回它的父目录对象的实例，得到父目录实 例后，接着调用.mkdirs()(是父目录这个实例调用的)，创建文件夹。 
			newFile.getParentFile().mkdirs(); 
			// 复制文件，把图片写入磁盘 
			file.getImage().transferTo(newFile); 
			return Msg.success().add("imagePath", newFileName); 
		} 
	
}













