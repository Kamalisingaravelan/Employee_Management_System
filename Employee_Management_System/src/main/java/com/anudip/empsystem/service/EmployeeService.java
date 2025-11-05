package com.anudip.empsystem.service;

import java.util.List;

import com.anudip.empsystem.dto.EmployeeDTO;
import com.anudip.empsystem.model.Employee;

public interface EmployeeService {

    Employee createEmployee(EmployeeDTO dto);
    Employee updateEmployee(Long id, EmployeeDTO dto);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    void deleteEmployee(Long id);
}
