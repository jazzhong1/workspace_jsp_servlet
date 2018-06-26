package com.test.el.model.vo;

public class Member {
	private String name;
	private int age;
	private String fruit;
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Member(String name, int age, String fruit, String hobby) {
		this.name = name;
		this.age = age;
		this.fruit = fruit;
		this.hobby = hobby;
	}


	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", fruit=" + fruit + ", hobby=" + hobby + "]";
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFruit() {
		return fruit;
	}
	public void setFruit(String fruit) {
		this.fruit = fruit;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	private String hobby;
}
