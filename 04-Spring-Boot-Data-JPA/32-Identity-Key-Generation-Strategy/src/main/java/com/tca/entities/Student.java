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
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	/*
		Hibernate: 
	    create table student (
	        rno integer not null,
	        birth_date date,
	        gender enum ('FEMALE','MALE','OTHER'),
	        name varchar(255),
	        per float(53),
	        primary key (rno)
	    ) engine=InnoDB
	Hibernate: 
	    create table student_seq (
	        next_val bigint
	    ) engine=InnoDB
	Hibernate: 
	    insert into student_seq ( next_val ) values ( 1 )
	    // in case of strategy=GenerationType.AUTO 
	 */
	@GeneratedValue(strategy=GenerationType.AUTO)
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