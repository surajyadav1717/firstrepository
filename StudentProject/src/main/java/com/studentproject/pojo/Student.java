package com.studentproject.pojo;

public class Student {

	private int id;
	private String name;
	private String rollno;
	private String grade;
	private String college;

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", rollno=" + rollno + ", grade=" + grade + ", college="
				+ college + "]";
	}

	
}