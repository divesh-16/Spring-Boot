package com.tca.entities;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	/*
		Hibernate: 
    create table student (
        rno binary(16) not null,
        birth_date date,
        gender enum ('FEMALE','MALE','OTHER'),
        name varchar(255),
        per float(53),
        primary key (rno)
    ) engine=InnoDB
	
	*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	@Column(name="RNO")
	private UUID rno;
	
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