package com.aaa.entity;
import com.aaa.util.DateSerializable;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

   /**
    * @文件名称：orders.java
    * @创建时间：2018-09-17 17:30:42
    * @创  建  人：sn 
    * @文件描述：orders 实体类
    * @文件版本：V0.01 
    */ 


public class Orders{
	private Integer orderNumber;
	// date转成字符串,后台返回前台数据
		@JsonSerialize(using = DateSerializable.class)
		// 前台传递一个字符串,后台接收日期类型
		@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDate;
		// date转成字符串,后台返回前台数据
		@JsonSerialize(using = DateSerializable.class)
		// 前台传递一个字符串,后台接收日期类型
		@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date requiredDate;
		// date转成字符串,后台返回前台数据
		@JsonSerialize(using = DateSerializable.class)
		// 前台传递一个字符串,后台接收日期类型
		@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date shippedDate;
	private String status;
	private String comments;
	private Integer customerNumber;

	public void setOrderNumber(Integer orderNumber){
		this.orderNumber=orderNumber;
	}

	public Integer getOrderNumber(){
		return orderNumber;
	}

	public void setOrderDate(Date orderDate){
		this.orderDate=orderDate;
	}

	public Date getOrderDate(){
		return orderDate;
	}

	public void setRequiredDate(Date requiredDate){
		this.requiredDate=requiredDate;
	}

	public Date getRequiredDate(){
		return requiredDate;
	}

	public void setShippedDate(Date shippedDate){
		this.shippedDate=shippedDate;
	}

	public Date getShippedDate(){
		return shippedDate;
	}

	public void setStatus(String status){
		this.status=status;
	}

	public String getStatus(){
		return status;
	}

	@Override
	public String toString() {
		return "Orders [orderNumber=" + orderNumber + ", orderDate="
				+ orderDate + ", requiredDate=" + requiredDate
				+ ", shippedDate=" + shippedDate + ", status=" + status
				+ ", comments=" + comments + ", customerNumber="
				+ customerNumber + "]";
	}

	public void setComments(String comments){
		this.comments=comments;
	}

	public String getComments(){
		return comments;
	}

	public void setCustomerNumber(Integer customerNumber){
		this.customerNumber=customerNumber;
	}

	public Integer getCustomerNumber(){
		return customerNumber;
	}

}

