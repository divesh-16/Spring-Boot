package com.tca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entities.Gender;
import com.tca.entities.Student;
import com.tca.repository.StudentRepository;

@Service("studentService")
public class StudentServiceImpl implements StudentService
{
	@Autowired
	StudentRepository repo;
	
	@Override
	public List<Student> fetchAllStudent() 
	{
		return repo.findAll();
	}
	
	@Override
	public List<Student> fetchPercentageRangeOfStudent(Double start, Double end) 
	{
		// return repo.findPercentageRangeUsingJPQL(start,end);
		return repo.findPercentageRangeUsingSQL(start, end);
	}
	
	@Override
	public List<Object[]> fetchGenderNamePer(Double per, Gender gender) 
	{
		//return repo.findGenderNamePerJPQL(per, gender);
		return repo.findGenderNamePerSQL(per, gender);
	}
}
