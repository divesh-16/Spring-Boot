package com.tca.beans;

public class Student 
{
	private Integer rno;
	private String name;
	private Double fees;
	private String passport;
	
	public Student(Integer rno, String name, Double fees) 
	{
		this.rno = rno;
		this.name = name;
		this.fees = fees;
	}
	
	public Integer getRno() {
		return rno;
	}
	public void setRno(Integer rno) {
		this.rno = rno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getFees() {
		return fees;
	}
	public void setFees(Double fees) {
		this.fees = fees;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	
	
}
