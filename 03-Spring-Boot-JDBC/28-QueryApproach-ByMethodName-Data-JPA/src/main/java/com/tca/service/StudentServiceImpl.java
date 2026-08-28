package com.tca.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.entities.Gender;
import com.tca.entities.Student;
import com.tca.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	StudentRepository repo;

	
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
	public List<Student> fetchByGender(Gender gender) 
	{
		return repo.findByGender(gender);
	}

	@Override
	public List<Student> fetchByBirthDate(LocalDate d) 
	{
		return repo.findByBirthDate(d);
	}

	@Override
	public List<Student> fetchByBirthDateGreaterThan(LocalDate d) 
	{
		return repo.findByBirthDateGreaterThan(d);
	}

	@Override
	public List<Student> fetchByPerBetween(Double start, Double end) 
	{
		return repo.findByPerBetween(start, end);
	}

	@Override
	public List<Student> fetchByBirthDateBetween(LocalDate start, LocalDate end) 
	{
		return repo.findByBirthDateBetween(start, end);
	}
	
	@Override
	public List<Student> fetchByBirthDateAfter(LocalDate d) 
	{
		return repo.findByBirthDateAfter(d);
	}

	@Override
	public List<Student> fetchByBirthDateBefore(LocalDate d) 
	{
		return repo.findByBirthDateBefore(d);
	}

	@Override
	public List<Student> fetchByNameStartingWithIgnoreCase(String s) 
	{
		return repo.findByNameStartingWithIgnoreCase(s);
	}
	
	@Override
	public List<Student> fetchByGenderOrderByPerDesc(Gender gender) 
	{
		return repo.findByGenderOrderByPerDesc(gender);
	}
	
	@Override
	public List<Student> fetchByGenderAndPerGreaterThanEqual(Gender gender, Double per) 
	{
		return repo.findByGenderAndPerGreaterThanEqual(gender, per);
	}
	@Override
	public Long getCountByGender(Gender gender) 
	{
		return repo.countByGender(gender);
	}
	
	@Override
	public boolean existsByRno(Integer rno) 
	{
		return repo.existsById(rno);
	}
}
