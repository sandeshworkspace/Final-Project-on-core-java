package com.nit.sf.pojo;

import java.io.Serializable;

import com.nit.sf.helper.CourseMap;

public class Student implements Serializable{
	
	//serial id of class
	private static final long serialVersionUID = 1L;
	
	private int sno;
	private String sname;
	private String course;
	private double fee;
	
	// one 0-param constructor
	public Student() {

	}
	
	//one parameterized constructor
	public Student(int sno,String sname,String course,double fee) {
		this.sno = sno;
		this.sname = sname;
		this.course = course;
		this.fee = fee;
	
	}
	
	//setters and getters for all properties
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
	
	@Override
	public int hashCode() {
		return CourseMap.getCoruseID(course);
	}
	
	@Override
	 public boolean equals(Object obj) {
		if(obj instanceof Student s) {
			return this.course.equalsIgnoreCase(course)&&
					this.sno == s.sno;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "\n\tStudent(" + sno + ", " + sname + ", " + course + ", " + fee + ")";
	}//toString 
}//class
