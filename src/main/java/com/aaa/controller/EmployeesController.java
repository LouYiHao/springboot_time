package com.aaa.controller;

import java.util.List;





import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa.entity.Employees;
import com.aaa.entity.Pagination;
import com.aaa.service.EmployeesService;

@Controller
@RequestMapping("e")
public class EmployeesController {
	
	@Resource
	EmployeesService e;
	
	@RequestMapping("find")
	@ResponseBody	
	public Pagination find(Integer page,Integer rows){
		page=(page-1)*rows;
			// 显示数据
		List<Employees> list = e.find(page, rows);
		// 总条数
		Long total = e.count();
		return new Pagination(total, list);
	}
	@RequestMapping("add")
	@ResponseBody
	public String add(Employees s){
		int add = e.add(s);
		if(add!=0){
			return "true";
		}
		return "error";
	}
	@RequestMapping("del")
	@ResponseBody
	public String del(Integer[] employeeNumbers){
		int add = e.del(employeeNumbers);
		if(add!=0){	 
			return "true";
		}
		return "false";
	}
	@RequestMapping("update")
	@ResponseBody
	public String update(Employees s){
		int add = e.update(s);
		if(add!=0){
			return "true";
		}
		return "erroe";
	}
}
