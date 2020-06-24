package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {

	
	@Autowired
	EmployeeRepo repo;
	
	
	@RequestMapping ("/")
	public String index()
	{
		return "index.jsp";
	}
	
	@RequestMapping ("/adddata")
	public String adddata(Employee employee)
	{
		repo.save(employee);
		return "adddata.jsp";
	}
	
	@RequestMapping ("/displayAll")
	@ResponseBody
	public List<Employee> getdata()
	{
		return repo.findAll();
	}
	
	
	@RequestMapping ("/display/{emp_id}")
	@ResponseBody
	public Optional<Employee> getemployeename(@PathVariable("emp_id")String emp_id)
	{
		return repo.findById(emp_id);
	}
	
}
