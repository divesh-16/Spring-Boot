package com.tca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tca.entities.Gender;
import com.tca.entities.Student;

import jakarta.transaction.Transactional;

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
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Student s WHERE s.gender=:gender")
	public Long deleteByGender(@Param("gender")Gender gender);
	
	@Modifying
	@Transactional
	@Query("UPDATE Student s SET s.per=:per WHERE s.rno=:rno")
	public Long updatePer(@Param("per")Double per, @Param("rno") Integer rno);
	
	
	@Query(value="UPDATE STUDENT SET GENDER=:gender WHERE RNO=:rno", nativeQuery = true)
	@Transactional
	@Modifying
	public Long updateGenderSQL(@Param("gender")Gender gender, @Param("rno") Integer rno);
	
}
