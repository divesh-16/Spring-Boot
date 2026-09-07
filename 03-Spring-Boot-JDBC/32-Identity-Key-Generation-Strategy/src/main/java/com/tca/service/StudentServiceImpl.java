package com.tca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entities.Student;
import com.tca.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	StudentRepository repo;
	
	@Override
	public List<Student> fetchAll() 
	{
		return (List<Student>) repo.findAll();
	}
	
	@Override
	public Optional<Student> getStudentById(Integer rno) 
	{
		return repo.findById(rno);
	}
	
	@Override
	public Student saveStudent(Student s) 
	{
		return repo.save(s);
	}
	
	@Override
	public List<Student> saveStudents(List<Student> students) 
	{
		return (List<Student>) repo.saveAll(students);
	}
}
