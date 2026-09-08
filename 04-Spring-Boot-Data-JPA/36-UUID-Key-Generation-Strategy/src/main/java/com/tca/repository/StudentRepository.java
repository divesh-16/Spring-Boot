package com.tca.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.tca.entities.Student;

public interface StudentRepository extends CrudRepository<Student, UUID>
{
	
}
