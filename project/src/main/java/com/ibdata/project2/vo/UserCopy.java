package com.ibdata.project2.vo;

public class UserCopy {
	
	private String id;
	private String name;
	private String emain;
	private String phone;
	private String sex;
	private String age;
	
	public UserCopy() {
		
	}
	
	public UserCopy(String id, String name, String emain, String phone, String sex) {
		this.id = id;
		this.name = name;
		this.emain = emain;
		this.phone = phone;
		this.sex = sex;
	}
	
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
	
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	
	
}
