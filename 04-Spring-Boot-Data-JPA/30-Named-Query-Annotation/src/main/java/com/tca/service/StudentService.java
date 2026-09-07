package com.tca.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.tca.dto.StudentDTO;
import com.tca.entities.Gender;
import com.tca.entities.Student;

public interface StudentService 
{
	public List<Student> fetchByGender(Gender gender);
	public List<StudentDTO> fetchAllStudentDTO();
	public Long updatePerByGender( Double per, Gender gender);
	public Long countByGender(Gender gender);
	public boolean existsByRno(Integer rno);
}
