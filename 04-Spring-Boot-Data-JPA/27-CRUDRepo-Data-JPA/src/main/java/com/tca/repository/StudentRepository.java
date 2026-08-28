package com.tca.repository;

import org.springframework.data.repository.CrudRepository;

import com.tca.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>
{

}
