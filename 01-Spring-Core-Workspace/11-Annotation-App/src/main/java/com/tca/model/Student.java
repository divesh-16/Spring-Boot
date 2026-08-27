package com.tca.model;

public class Student 
{
	private Integer rno;
	private String name;
	private String city;
	private Double per;

	public Student(Integer rno,String name,String city,Double per)
	{
		this.rno = rno;
		this.name = name;
		this.per = per;
		this.city = city;
	}

	public String toString()
	{
		return "[ rno : "+rno+", name : "+name+", city : "+city+", per : "+per+" ]";
	}
}
