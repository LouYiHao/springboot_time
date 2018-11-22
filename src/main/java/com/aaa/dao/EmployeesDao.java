package com.aaa.dao;

import com.aaa.entity.Employees;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface EmployeesDao {
	@Select("select * from Employees limit #{param1},#{param2}")
	public List<Employees> find(Integer pagenum, Integer pagesize);
	@Select("select count(*) from Employees")
	public Long count();
	@Insert("insert into Employees(\temployeeNumber,\n" +
			"lastName,\n" +
			"firstName,\n" +
			"extension,\n" +
			"email,\n" +
			"officeCode,\n" +
			"reportsTo,\n" +
			"jobTitle\t)\n" +
			"\t\tvalues(#{employeeNumber},#{lastName},#{firstName},#{extension},#{email},\n" +
			"\t\t#{officeCode},#{reportsTo},#{jobTitle})")
	public int add(Employees e);
	@Delete("<script>delete from Employees where employeeNumber in\n" +
			"\t\t<foreach collection=\"array\" index=\"index\" item=\"xx\" open=\"(\" close=\")\" separator=\",\">\n" +
			"\t\t\t#{xx}\n" +
			"\t\t</foreach></script>")
	public int del(Integer[] id);
	@Update("update Employees set\n" +
			"\t\t\t\tlastName=#{lastName},\n" +
			"\t\t\t\tfirstName=#{firstName},\n" +
			"\t\t\t\textension=#{extension},\n" +
			"\t\t\t\temail=#{email},\n" +
			"\t\t\t\tofficeCode=#{officeCode},\n" +
			"\t\t\t\treportsTo=#{reportsTo},\n" +
			"\t\t\t\tjobTitle=#{jobTitle}\n" +
			"\twhere \temployeeNumber=#{employeeNumber}")
	public int update(Employees e);
}
