package com.aaa.entity;

   /**
    * admins 实体类
    * Sat Nov 10 15:27:54 GMT+08:00 2018 娄轶豪
    */ 


public class Admins{
	private String id;
	private String name;
	private String pwd;
	private String tx;

	@Override
	public String toString() {
		return "Admins [id=" + id + ", name=" + name + ", pwd=" + pwd + ", tx="
				+ tx + "]";
	}
	public void setId(String id){
	this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setName(String name){
	this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setPwd(String pwd){
	this.pwd=pwd;
	}
	public String getPwd(){
		return pwd;
	}
	public void setTx(String tx){
	this.tx=tx;
	}
	public String getTx(){
		return tx;
	}
}

