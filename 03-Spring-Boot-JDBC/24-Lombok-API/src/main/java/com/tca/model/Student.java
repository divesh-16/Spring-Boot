package com.tca.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@NoArgsConstructor
//@AllArgsConstructor
@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class Student 
{
	private final int birthDate;
	private int rno;
	private String name;
	private double per;
	
	
}
