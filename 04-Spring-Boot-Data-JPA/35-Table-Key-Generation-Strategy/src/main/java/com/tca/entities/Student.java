package com.tca.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="STUDENT")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="rno_gen")
	@TableGenerator(name="rno_gen",
					table="id_generator",
					pkColumnName = "gen_name",
					valueColumnName = "gen_value",
					pkColumnValue = "student_id",
					allocationSize = 1)
	@Column(name="RNO")
	private Integer rno;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PER")
	private Double per;
	
	@Enumerated(EnumType.STRING)
	@Column(name="GENDER")
	private Gender gender;
	
	
	@Column(name="birth_date")
	private LocalDate birthDate;
}