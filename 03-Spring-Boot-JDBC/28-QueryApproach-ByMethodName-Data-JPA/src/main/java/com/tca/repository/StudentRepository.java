package com.tca.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tca.entities.Gender;
import com.tca.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>
{
	public List<Student> findByGender(Gender gender);
	public List<Student> findByBirthDate(LocalDate d);
	public List<Student> findByBirthDateGreaterThan(LocalDate d);
	public List<Student> findByPerBetween(Double start, Double end);
	public List<Student> findByBirthDateBetween(LocalDate start, LocalDate end);
	public List<Student> findByBirthDateAfter(LocalDate d);
	public List<Student> findByBirthDateBefore(LocalDate d);
	public List<Student> findByNameStartingWithIgnoreCase(String s);
	
	public List<Student> findByGenderOrderByPerDesc(Gender gender);
	
	public List<Student> findByGenderAndPerGreaterThanEqual(Gender gender, Double per);
	
	public Long countByGender(Gender gender);
	
	public boolean existsByRno(Integer rno);
	
}
