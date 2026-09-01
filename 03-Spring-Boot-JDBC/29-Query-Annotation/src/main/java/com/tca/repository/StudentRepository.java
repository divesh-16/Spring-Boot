package com.tca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tca.entities.Gender;
import com.tca.entities.Student;

public interface StudentRepository extends CrudRepository<Student,Integer>
{
//	@Query("SELECT s from Student s")
	@Query(value="SELECT * FROM STUDENT", nativeQuery = true)
	public List<Student> findAll();

	//	@Query("SELECT s FROM Student s where per>=?1 and per<=?2")	// JPQL positional Parameter
	@Query("SELECT s FROM Student s where per>=:low and per<=:high")	// JPQL Name Parameter
	public List<Student> findPercentageRangeUsingJPQL(@Param("low")Double start, @Param("high") Double end);
	
//	@Query(value="SELECT * FROM Student  where PER>=?1 and PER<=?2", nativeQuery = true)// SQL positional Parameter
	@Query(value="SELECT * FROM Student  where PER>=:low and PER<=:high", nativeQuery = true) // SQL Name Parameter
	public List<Student> findPercentageRangeUsingSQL(@Param("low")Double start, @Param("high") Double end);
	
	@Query("SELECT s.name, s.per, s.gender FROM Student s where s.per>=:per and s.gender=:gender")
	public List<Object[]> findGenderNamePerJPQL(@Param("per") Double per, @Param("gender") Gender gender);
	
	@Query(value="SELECT NAME, PER, GENDER FROM STUDENT WHERE per>=:per and gender=:gender", nativeQuery = true)
	public List<Object[]> findGenderNamePerSQL(@Param("per") Double per, @Param("gender") Gender gender);
	
	
}
