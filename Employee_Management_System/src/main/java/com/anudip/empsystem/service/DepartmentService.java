package com.anudip.empsystem.service;

import java.util.List;

import com.anudip.empsystem.dto.DepartmentDTO;
import com.anudip.empsystem.model.Department;

public interface DepartmentService {

    Department createDepartment(DepartmentDTO dto);
    Department updateDepartment(Long id, DepartmentDTO dto);
    Department getDepartmentById(Long id);
    List<Department> getAllDepartments();
    void deleteDepartment(Long id);
}
