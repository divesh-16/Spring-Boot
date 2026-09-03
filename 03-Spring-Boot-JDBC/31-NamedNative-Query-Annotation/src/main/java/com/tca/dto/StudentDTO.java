package com.tca.dto;

import java.time.LocalDate;

import com.tca.entities.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO 
{
	private String name;
	private Double per;
	private Gender gender;
}
