package com.tca.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="STUDENT")
@NoArgsConstructor
@AllArgsConstructor
@Data
@NamedNativeQuery(name = "Student.findByGender", query = "select * from student where gender=:gender", resultClass = Student.class)
@NamedNativeQuery(name = "Student.updatePerByGender", query = "UPDATE STUDENT SET per=:per WHERE gender=:gender")
@NamedNativeQuery(name = "Student.countByGender", query="SELECT count(*) FROM STUDENT WHERE gender=:gender")
public class Student 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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