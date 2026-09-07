package com.tca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.dto.StudentDTO;
import com.tca.entities.Gender;
import com.tca.entities.Student;
import com.tca.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	StudentRepository repo;
	
	@Override
	public List<Student> fetchByGender(Gender gender) 
	{
		return repo.findByGender(gender);
	}
	
	@Override
	public List<StudentDTO> fetchAllStudentDTO() 
	{
		List<Student> list = (List<Student>) repo.findAll();
		
		List<StudentDTO> list2 = new ArrayList<>();
		for(Student s : list)
		{
			StudentDTO dto = new StudentDTO();
			dto.setName(s.getName());
			dto.setGender(s.getGender());
			dto.setPer(s.getPer());
			
			list2.add(dto);
		}
		
		return list2;
	}
	
	@Override
	public Long updatePerByGender(Double per, Gender gender) 
	{
		return repo.updatePerByGender(per, gender);
	}
	
	@Override
	public Long countByGender(Gender gender) 
	{
		return repo.countByGender(gender);
	}
	
	@Override
	public boolean existsByRno(Integer rno) 
	{
		return repo.existsByRno(rno);
	}
}
