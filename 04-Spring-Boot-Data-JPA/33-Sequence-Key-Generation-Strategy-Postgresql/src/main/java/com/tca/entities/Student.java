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
import jakarta.persistence.SequenceGenerator;
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
    
    create table student 
    (
        rno integer not null,
        birth_date date,
        gender varchar(255) check ((gender in ('MALE','FEMALE','OTHER'))),
        name varchar(255),
        per float(53),
        primary key (rno)
    )
	Hibernate: 
	    create sequence student_seq start with 1 increment by 1
	 */
	
	@Id
//	@SequenceGenerator(name="rno_gen",
//						sequenceName = "student_seq",	// Sequence name at DB side
//						allocationSize = 1)	// must match increment by in the sequence
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "rno_gen")
	/*
	 Hibernate: 
    create table student (
        rno integer not null,
        birth_date date,
        gender varchar(255) check ((gender in ('MALE','FEMALE','OTHER'))),
        name varchar(255),
        per float(53),
        primary key (rno)
    )
	Hibernate: 
	    create sequence student_seq start with 1 increment by 50
	    // in case of strategy=GenerationType.AUTO in postgresql
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