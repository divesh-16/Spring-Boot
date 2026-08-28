package com.tca.service;

import java.util.List;
import java.util.Optional;

import com.tca.entities.Student;

public interface StudentService 
{
	public abstract Student saveStudent(Student student);
	public abstract Student updateStudent(Student student);
	public abstract Student saveOrUpdateStudent(Student student);
	public abstract Optional<Student> fetchById(Integer rno);
	public abstract List<Student> fetchAllStudent();
	public abstract boolean deleteStudentById(Integer rno);
	public abstract List<Student> saveAll(List<Student> students);
	public abstract Long count();
	public abstract boolean deleteStudent(Student student);
	public abstract boolean deleteAllStudent();
	public abstract boolean deleteStudents(List<Student> students);
	public abstract boolean deleteStudentsById(List<Integer> ids);
}
