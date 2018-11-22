package com.aaa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.EmployeesDao;
import com.aaa.entity.Employees;

@Service
@Transactional
public class EmployeesService {
	@Resource
	EmployeesDao dao;
	
	public List<Employees> find(Integer pagenum,Integer pagesize){
		List<Employees> find = dao.find(pagenum, pagesize);
		return find;
	}
	
	public Long count(){
		Long count = dao.count();
		return count;
	}
	
	public int add(Employees e){
		int add = dao.add(e);
		return add;
	}
	
	public int del(Integer[] employeeNumbers){
		int del = dao.del(employeeNumbers);
		return del;
	}
	
	public int update(Employees e){
		int update = dao.update(e);
		return update;
	}
}
