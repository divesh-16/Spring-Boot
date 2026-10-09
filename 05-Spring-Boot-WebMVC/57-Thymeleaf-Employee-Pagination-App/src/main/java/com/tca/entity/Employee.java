package com.tca.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee 
{
	@Id
	private int eno;
	private String name;
	private double salary;
	private int deptno;
}
