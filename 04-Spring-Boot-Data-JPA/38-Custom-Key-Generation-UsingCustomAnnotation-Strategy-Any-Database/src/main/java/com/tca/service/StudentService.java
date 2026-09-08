package com.tca.service;

import java.util.List;
import java.util.Optional;

import com.tca.entities.Student;

public interface StudentService 
{
	public List<Student> fetchAll();
	public Optional<Student> getStudentById(String rno);
	public Student saveStudent(Student s);
	public List<Student> saveStudents(List<Student> students);
	
}
