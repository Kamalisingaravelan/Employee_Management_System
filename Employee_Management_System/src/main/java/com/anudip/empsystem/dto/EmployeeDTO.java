package com.anudip.empsystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeDTO {

		private Long id;

	    @NotBlank(message = "Name required")
	    @Size(max = 100)
	    private String name;

	    @NotBlank(message = "Designation required")
	    private String designation;

	    @Email(message = "Invalid email")
	    private String email;

	    private Double salary;

	    private Long departmentId; // link to Department
	    

	    // ✅ Default constructor
	    public EmployeeDTO() {}

	    // ✅ Parameterized constructor
	    public EmployeeDTO(String name, String designation, String email, double salary, Long departmentId) {
	        this.name = name;
	        this.designation = designation;
	        this.email = email;
	        this.salary = salary;
	        this.departmentId = departmentId;
	    }

	    // ✅ Getters and Setters
	    
	    
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDesignation() {
	        return designation;
	    }

	    public void setDesignation(String designation) {
	        this.designation = designation;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public double getSalary() {
	        return salary;
	    }

	    public void setSalary(double salary) {
	        this.salary = salary;
	    }

	    public Long getDepartmentId() {
	        return departmentId;
	    }

	    public void setDepartmentId(Long departmentId) {
	        this.departmentId = departmentId;
	    }
}
