package com.tca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tca.entity.Employee;
import com.tca.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	EmployeeRepository repo;

	@Override
	public List<Employee> fetchAllEmployee() 
	{
		return repo.findAll();
	}
	
	@Override
	public Page<Employee> fetchAllEmployee(int PgNo) 
	{
		Pageable p = PageRequest.of(PgNo, 5);
		return repo.findAll(p);
	}
	
	@Override
	public List<Integer> getPageNumberList(boolean hasPrevious, boolean hasNext, int curr, int totalPages) 
	{
		int n = 5;	// Number of pages always shown 
		
		
		// base condition
		if(!hasPrevious)	// display first n pages;
		{
			List<Integer> L = new ArrayList<>();
			for(int i = 1; i<=n && i<totalPages; i++)
			{
				L.add(i);
			}
			return L;
 		}
		
		// base condition
		if(!hasNext)	// display last n pages;
		{
			List<Integer> L = new ArrayList<>();
			for(int i = totalPages-1;  i>=0 && L.size()<n ; i--)
			{
				L.add(0,i); // ascending order
			}
			return L;
 		}
		
		
		List<Integer> L = new ArrayList<>();
		L.add(curr);
		
		
		int leftMax = 2, rightMax =2; // left & right max will be dynamic i.e based on pages on either side leftMax and rightMax will decided
		// but initially we will take 2 from each side
		
		
		// 3 Condition to pages
		// 1st Condition if both left and right side have greater than required pages then take equal pages from both side (i'm taking 2 because I want 5 links)
		if(curr-leftMax >=0 && curr+rightMax < totalPages)
		{
			int lcnt = 0;
		
			while(lcnt < leftMax && (curr-(lcnt+1)) >=0 && L.size()<=n)
			{
				//System.out.println((curr-(lcnt+1)));
				L.add(0, (curr-(lcnt+1)));
				lcnt++;
			}
			
			//int rightMax = n-(lcnt+1); //+1 for curr element
			int rcnt = 0;
			
			while(rcnt < rightMax && (curr+(rcnt+1)) < totalPages && L.size()<=n)
			{
				L.add((curr+(rcnt+1)));
				rcnt++;
			}
			
			
			return L;
		}
		else if(curr-leftMax >=0)
		{
			// 2nd Condition left have more pages and right have less pages than required i.e So take all pages from right and rest pages from left
			int rcnt = 0;
			while(rcnt < rightMax && (curr+(rcnt+1)) < totalPages && L.size()<=n)
			{
				L.add((curr+(rcnt+1)));
				rcnt++;
			}	
		
			leftMax = n-(rcnt+1);	// take more from left side
			
			
			int lcnt = 0;
			while(lcnt < leftMax && (curr-(lcnt+1)) >=0 && L.size()<=n)
			{
				//System.out.println((curr-(lcnt+1)));
				L.add(0, (curr-(lcnt+1)));
				lcnt++;
			}
			return L;
			
		}
		else
		{
			// 3rd Condition : right have more pages and left have less pages than required i.e So take all pages from left and rest pages from right
			int lcnt = 0;
			
			while(lcnt < leftMax && (curr-(lcnt+1)) >=0 && L.size()<=n)
			{
				//System.out.println((curr-(lcnt+1)));
				L.add(0, (curr-(lcnt+1)));
				lcnt++;
			}
			
			rightMax = n-(lcnt+1);	// take more pages from right side
			//int rightMax = n-(lcnt+1); //+1 for curr element
			int rcnt = 0;
			
			while(rcnt < rightMax && (curr+(rcnt+1)) < totalPages && L.size()<=n)
			{
				L.add((curr+(rcnt+1)));
				rcnt++;
			}
			
			return L;
		}
	}

}
