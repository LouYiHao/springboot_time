package com.aaa.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.aaa.entity.Admins;
@Mapper
public interface AdminsDao {
	@Select("select * from admins where name=#{param1} and pwd=#{param2}")
	public Admins Login(String name, String pwd);
}
