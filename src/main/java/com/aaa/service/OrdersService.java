package com.aaa.service;

import com.aaa.dao.OrdersDao;
import com.aaa.entity.Orders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class OrdersService {
	@Resource
	OrdersDao s;
	public List<Orders> find(Integer pagesize,Integer pagenum){
		return s.find(pagesize, pagenum);
	}
	
	public Long count(){
		return s.count();
	}
	public int del(Integer[] ordernumbers){
		return s.del(ordernumbers);
	}
	public int update(Orders o){
		return s.update(o);
	}
	public int add(Orders o){
		return s.add(o);
	}
}	
