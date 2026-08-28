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
	public Student saveStudent(Student student) 
	{
		return repo.save(student);
	}

	@Override
	public Student updateStudent(Student student) 
	{
		return repo.save(student);
	}

	@Override
	public Student saveOrUpdateStudent(Student student) 
	{
		return repo.save(student);
	}

	@Override
	public Optional<Student> fetchById(Integer rno) 
	{
		return repo.findById(rno);
	}

	@Override
	public List<Student> fetchAllStudent() {
		return (List<Student>) repo.findAll();
	}

	@Override
	public boolean deleteStudentById(Integer rno) 
	{
		if(repo.existsById(rno))
		{
			repo.deleteById(rno);
			return true;
		}
		
		return false;
	}

	@Override
	public List<Student> saveAll(List<Student> students) 
	{
		return (List<Student>) repo.saveAll(students);
	}

	@Override
	public Long count() 
	{
		return repo.count();
	}

	@Override
	public boolean deleteStudent(Student student) 
	{
		if(student != null && repo.existsById(student.getRno()))
		{
			repo.delete(student);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAllStudent() 
	{
		if(repo.count() > 0)
		{
			repo.deleteAll();
			return true;
		}
		
		return false;
	}

	@Override
	public boolean deleteStudents(List<Student> students) 
	{
		if(students != null && !students.isEmpty())
		{
			long initialCount = repo.count();
			repo.deleteAll(students);
			long afterCount = repo.count();
			if(initialCount == afterCount)
			{
				return false;
			}
			
			return true;
		}
		
		throw new IllegalArgumentException("The students list cannot be null or empty.");
	}

	@Override
	public boolean deleteStudentsById(List<Integer> ids) 
	{
		if(ids != null && !ids.isEmpty())
		{
			long initialCount = repo.count();
			repo.deleteAllById(ids);
			long afterCount = repo.count();
			if(initialCount == afterCount)
			{
				return false;
			}
			
			return true;
		}
		
		throw new IllegalArgumentException("The ids list cannot be null or empty.");
	}

}
