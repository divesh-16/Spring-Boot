package com.tca.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.tca.dto.StudentDTO;
import com.tca.entities.Gender;
import com.tca.entities.Student;

public interface StudentService 
{
	List<Student> fetchByGender(Gender gender);
	List<StudentDTO> fetchAllStudentDTO();
	public Long updatePerByGender(Double per,  Gender gender);
	public Long countByGender(Gender gender);
}
