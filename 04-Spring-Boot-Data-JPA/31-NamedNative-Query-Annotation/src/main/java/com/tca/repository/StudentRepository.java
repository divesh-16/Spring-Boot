package com.tca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tca.entities.Gender;
import com.tca.entities.Student;

import jakarta.transaction.Transactional;

public interface StudentRepository extends CrudRepository<Student, Integer>
{
	@Query(nativeQuery = true)
	public List<Student> findByGender(@Param("gender") String gender);
	@Modifying
	@Transactional
	@Query(nativeQuery = true)
	public Long updatePerByGender(@Param("per")Double per, @Param("gender") String gender);
	
	
	
	@Query(nativeQuery = true)
	public Long countByGender(@Param("gender")String gender);
	
	public boolean existsByRno(@Param("rno")Integer rno);
}
