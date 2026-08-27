package com.tca.repository;

import java.util.List;
import java.util.Map;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.tca.model.Student;

@Repository
public class StudentRepository 
{
	@Autowired
	JdbcTemplate jt;
	
	@Autowired
	SimpleJdbcCall jdbcCall;
	
	public void saveStudent(Student student)
	{
		String sql = "insert into student values(?,?,?,?)";
		jt.update(sql, student.getRno(),student.getName(),student.getPer(),student.getCity());
		System.out.println("Record Saved Successfully");
	}
	
	public void deleteStudent(int rno)
	{
		String sql = "delete from student where rno = ?";
		int update = jt.update(sql, rno);
		
		if(update >0)
		{
			System.out.println("Delete Successfull");
		}
		else
		{
			System.out.println("Delete not Successfull");
		}
	}
	
	public void updateStudent(Student student)
	{
		String sql = "update student set name=?, per=?, city=? where rno=?";
		int update = jt.update(sql,student.getName(),student.getPer(),student.getCity(), student.getRno());
		if(update > 0)
		{
			System.out.println("Record Updated Successfully");
		}
		else
		{
			System.out.println("Record not Updated Successfully");
		}
	}
	
	public Map<String, Object> getStudentById(int rno)
	{
		String sql = "select * from student where rno = ?";
		return jt.queryForMap(sql,rno);
		
	}
	
	public List<Map<String, Object>> getAllStudent()
	{
		String sql = "select * from student";
		return jt.queryForList(sql);
	}
	
	public String getStudentGrade(int rno)
	{
		jdbcCall.withFunctionName("get_grade");
		// Put database name To get that database's function
		jdbcCall.withCatalogName("springboot");
		
		Map<String,Object> map = jdbcCall.execute(rno);
		
		return map.get("return").toString();
		
	}
}
