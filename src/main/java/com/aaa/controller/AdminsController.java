package com.aaa.controller;





import com.aaa.entity.Admins;
import com.aaa.service.AdminsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("admin")
public class AdminsController {
	@Resource
	AdminsService a;
	
	@RequestMapping("login")
	public String Login(String name,String pwd,HttpSession s){
		Admins login = a.Login(name, pwd);
		
		if(login!=null){
		s.setAttribute("login", login);
		return "list";
		}
		else{
			return "loginerror";
		}
	}
}
