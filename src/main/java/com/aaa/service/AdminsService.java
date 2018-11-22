package com.aaa.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.AdminsDao;
import com.aaa.entity.Admins;

@Service
@Transactional
public class AdminsService {
	@Resource
	AdminsDao dao;
	public Admins Login(String name,String pwd){
		return dao.Login(name, pwd);
	}
}
