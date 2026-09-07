package com.tca.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.tca.entities.Gender;
import com.tca.entities.Student;

public interface StudentService 
{
	public abstract Optional<Student> fetchById(Integer rno);
	public abstract List<Student> fetchAllStudent();
	
	public abstract List<Student> fetchByGender(Gender gender);
	public abstract List<Student> fetchByBirthDate(LocalDate d);
	public List<Student> fetchByBirthDateGreaterThan(LocalDate d);
	public List<Student> fetchByPerBetween(Double start, Double end);
	public List<Student> fetchByBirthDateBetween(LocalDate start, LocalDate end);
	public List<Student> fetchByBirthDateAfter(LocalDate d);
	public List<Student> fetchByBirthDateBefore(LocalDate d);
	public List<Student> fetchByNameStartingWithIgnoreCase(String s);
	public List<Student> fetchByGenderOrderByPerDesc(Gender gender);
	public List<Student> fetchByGenderAndPerGreaterThanEqual(Gender gender, Double per);
	public Long getCountByGender(Gender gender);
	public boolean existsByRno(Integer rno);
}
