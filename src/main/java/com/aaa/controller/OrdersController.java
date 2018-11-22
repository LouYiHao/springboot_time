package com.aaa.controller;

import com.aaa.entity.Orders;
import com.aaa.entity.Pagination;
import com.aaa.service.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("orders")
public class OrdersController {
	@Resource
	OrdersService s;
	
	@RequestMapping("list")
	@ResponseBody
	public Pagination list(Integer page,Integer rows){
		page=(page-1)*rows;
		Long count = s.count();
		List<Orders> find = s.find(page, rows);
		return new Pagination(count, find);
	}

	@RequestMapping("del")
	@ResponseBody
	public String del(Integer[] orderNumbers){
		System.out.println(orderNumbers.length);
		int del = s.del(orderNumbers);
		if(del!=0){
			return "true";
		}
		return "false";
	}
	@RequestMapping("add")
	@ResponseBody
	public String add(Orders o){
		System.out.println(o.toString());
		int del = s.add(o);
		if(del!=0){
			return "true";
		}
		return "false";
	}
	@RequestMapping("update")
	@ResponseBody
	public String update(Orders o){
		System.out.println(o);
		int del = s.update(o);
		if(del!=0){
			return "true";
		}
		return "false";
	}
}
