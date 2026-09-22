package com.tca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entity.Student;
import com.tca.repository.StudentRepository;

@Service("studentService")
public class StudentServiceImpl implements StudentService
{
	@Autowired
	StudentRepository repo;

	@Override
	public Student saveStudent(Student student) 
	{
		return repo.save(student);
	}

	@Override
	public Student fetchById(Integer rno) 
	{
		return repo.findById(rno).get();
	}

}
