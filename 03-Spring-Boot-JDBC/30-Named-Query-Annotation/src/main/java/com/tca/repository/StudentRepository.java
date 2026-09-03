package com.tca.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tca.entities.Gender;
import com.tca.entities.Student;

import jakarta.transaction.Transactional;

public interface StudentRepository extends CrudRepository<Student, Integer>
{
	public List<Student> findByGender(@Param("gender") Gender gender);
	@Modifying
	@Transactional
	public Long updatePerByGender(@Param("per")Double per, @Param("gender") Gender gender);
	
	
	
	
	public Long countByGender(@Param("gender")Gender gender);
	
	public boolean existsByRno(@Param("rno")Integer rno);
}
