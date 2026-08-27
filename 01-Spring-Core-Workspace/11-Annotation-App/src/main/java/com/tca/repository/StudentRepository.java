package com.tca.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tca.model.Student;

@Repository
public class StudentRepository 
{
	@Autowired
	Map<String, Student> map;
	
	public Student findById(String studentId)
	{
		return map.get(studentId);
	}
	
	public Map<String, Student> findAll()
	{
		return map;
	}
}
