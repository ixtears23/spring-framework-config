package com.ibdata.project.custom;

public class User {
	
	private String id;
	private String name;
	private String emain;
	private String phone;
	private String sex;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmain() {
		return emain;
	}
	public void setEmain(String emain) {
		this.emain = emain;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	
	
}
