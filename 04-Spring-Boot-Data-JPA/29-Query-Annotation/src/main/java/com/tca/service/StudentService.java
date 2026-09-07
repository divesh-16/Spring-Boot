package com.tca.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.tca.entities.Gender;
import com.tca.entities.Student;

public interface StudentService 
{
	public List<Student> fetchAllStudent();
	public List<Student> fetchPercentageRangeOfStudent(Double start, Double end);
	public List<Object[]> fetchGenderNamePer(Double per, Gender gender);
	public Long deleteByGender(Gender gender);
	public Long updatePer(Double per, Integer rno);
	public Long updateGenderSQL(Gender gender, Integer rno);
}
