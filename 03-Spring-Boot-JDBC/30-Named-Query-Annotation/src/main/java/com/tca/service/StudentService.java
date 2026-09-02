package com.tca.service;

import java.util.List;

import com.tca.dto.StudentDTO;
import com.tca.entities.Gender;
import com.tca.entities.Student;

public interface StudentService 
{
	List<Student> fetchByGender(Gender gender);
	List<StudentDTO> fetchAllStudentDTO();
}
