package com.hp.assigments05;

public class Student {
	private int sno;
	private String name;
	private String sex;
	private int age;
	private int java;
	public Student(int sno, String name, String sex, int age, int java) {
		super();
		this.sno = sno;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.java = java;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public void cell() {
		System.out.println("学号:"+sno+",姓名:"+name+",性别:"+sex+",年龄:"+age+",java成绩:"+java+"分");
	}
}
