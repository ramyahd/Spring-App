package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
public class SpringbootAssignmentTests {

	 @Autowired
	    private EmployeeRepo repo;
	 

	    @Test
	    @Rollback(false)
	    @Order(1)
	    public void testCreateProduct() {
	    	Employee employee = new Employee("20094423","vishwas@wipro.com","pune","vishwas");
	    	Employee Savedemployee = repo.save(employee);
	    	
	    	assertNotNull(Savedemployee.getEmp_id().isEmpty());
	    }
	    	
	    	
	    @Test
	    @Order(2)
	    public void testListProducts() {
	        List<Employee> employees = (List<Employee>) repo.findAll();
	        
	        for (Employee employee : employees)
	        {
	        	System.out.println(employee);
	        }
	        assertThat(employees).size().isGreaterThan(0);
	    }
	     
	    @Test
	    @Rollback(false)
	    @Order(3)
	    public void testDeleteProduct() {
	    	String emp_id = "20094409";
	    	
	    	boolean isExistBeforDelete = repo.findById(emp_id).isPresent();
	    	repo.deleteById(emp_id);
	    	boolean notExistAfterDelete = repo.findById(emp_id).isPresent();
	    	assertTrue(isExistBeforDelete);
	    	assertFalse(notExistAfterDelete);  
	         
	    }
	   
	    
	    
}
