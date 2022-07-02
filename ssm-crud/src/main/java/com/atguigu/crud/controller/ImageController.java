package com.atguigu.crud.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
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

import junit.framework.Test;

@RestController
@RequestMapping("/image")
@CrossOrigin //允许所有ip跨域
public class ImageController {
	
		@RequestMapping("/set") 
		 public Msg oneFileUpload(  
		            @RequestParam("file") CommonsMultipartFile file,@RequestParam("mealsid")  String mealsid,
		            HttpServletRequest request, ModelMap model) throws IOException {  
		  
		        // 获得原始文件名  
		        String fileName = file.getOriginalFilename();
		        
		        System.out.println("原始文件名:" + fileName);  
		  
		        
		     // 新文件名  
		        String newFileName = mealsid+".png";  
		  
		        // 获得项目的路径  
		        //ServletContext sc = request.getSession().getServletContext();  
		        // 上传位置  
		       // String path = sc.getRealPath("/img") + "/"; // 设定文件保存的目录  
		        String path1 = ClassUtils.getDefaultClassLoader().getResource("image").getPath();
		        String contextPath = request.getContextPath();      
		        String realPath = request.getSession().  
		                        getServletContext().getRealPath("/");      
		        String basePath = request.getScheme()+"://"+request.getServerName()+":"+  
		                        request.getServerPort()+contextPath+"/";  
//		        windows文件路径
//		        String path=realPath+"static\\images\\";
		        
//		        linux文件路径
		        String path=realPath+"static/images/";
		        
		        System.out.println("path:" + path);  
		        System.out.println("path1:" + path1);  
		        System.out.println("contextPath:" + contextPath);  
		        System.out.println("realPath:" + realPath);  
		        System.out.println("basePath:" + basePath);  
		        
		        File f = new File(path); 
		        System.out.println("f:---" + f.getPath());
		        if (!f.exists())  
		            f.mkdirs();  
		        if (!file.isEmpty()) {  
		            try {  
		                FileOutputStream fos = new FileOutputStream(path +""+ newFileName);  
		                InputStream in = file.getInputStream();  
		                int b = 0;  
		                while ((b = in.read()) != -1) {  
		                    fos.write(b);  
		                } 
		                fos.close();  
		                in.close();  
		            } catch (Exception e) {  
		                e.printStackTrace();  
		            }  
		        }  
		        System.out.println("f:---+++++" + f.getPath());
		        System.out.println("上传图片到:" + path +""+ newFileName);  
		        // 保存文件地址，用于JSP页面回显  
		        model.addAttribute("fileUrl", basePath +""+ newFileName);  
		        
		        String src = basePath +"static/images/"+ newFileName;
				return Msg.success().add("path", src);
		}
	
}
