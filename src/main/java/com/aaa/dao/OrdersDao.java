package com.aaa.dao;

import com.aaa.entity.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrdersDao {
	@Select("select * from orders limit #{param1},#{param2}")
	public List<Orders> find(Integer pagesize, Integer pagenum);
	@Select("select count(*) from orders")
	public Long count();
	
	@Insert("insert into orders values(#{orderNumber},#{orderDate},#{requiredDate},#{shippedDate}"
			+ ",#{status},#{comments},#{customerNumber})")
	public int add(Orders o);
	
	@Delete("<script>delete  from orders where orderNumber in "
		+ "<foreach collection='array' index='index' item='sss'"
		+ " open='(' close=')' separator=','>"
		+"#{sss}"
		+"</foreach></script>")
	public int del(Integer[] orderNumber);
	
	@Update("update table orders set orderDate=#{orderDate},requiredDate=#{requiredDate},"
			+ "shippedDate=#{shippedDate}"
			+ ",status=#{status},comments=#{comments},"
			+ "customerNumber=#{customerNumber} where orderNumber=#{orderNumber}")
	public int update(Orders o);
}	
