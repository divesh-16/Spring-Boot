package com.tca.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tca.entities.Gender;
import com.tca.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>
{
	List<Student> findByGender(@Param("gender") Gender gender);
}
