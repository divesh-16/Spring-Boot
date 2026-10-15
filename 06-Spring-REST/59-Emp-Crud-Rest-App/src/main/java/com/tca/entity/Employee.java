package com.tca.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee 
{
	@Id
	private Integer empno;
	private String name;
	private Double salary;
	private Integer deptno;
}
