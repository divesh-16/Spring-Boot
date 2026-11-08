package com.tca.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(description = "Details about the Student entity instance")
public class Employee 
{
	@Id
	@Schema(description="Integer eno which needs to provided")
	private Integer eno;
	
	@Schema(description="String name to be given to employee with above id")
	private String name;
	
	@Schema(description="Salary of above enployee with id")
	private Double salary;
	
	@Schema(description="Department number of above employee")
	private Integer deptno;
}
