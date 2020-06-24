package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String emp_id;
    private String emp_name;
    private String emp_loc;
    private String emp_email;
    
    public Employee() {
  		super();
  		// TODO Auto-generated constructor stub
  	}

    public  String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_loc() {
		return emp_loc;
	}
	public void setEmp_loc(String emp_loc) {
		this.emp_loc = emp_loc;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_loc=" + emp_loc + ", emp_email="
				+ emp_email + "]";
	}
	
	public Employee(String emp_id, String emp_name, String emp_loc, String emp_email) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_loc = emp_loc;
		this.emp_email = emp_email;
	}
	
}
