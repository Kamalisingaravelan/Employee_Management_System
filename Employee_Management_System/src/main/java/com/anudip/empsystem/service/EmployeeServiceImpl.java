package com.anudip.empsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anudip.empsystem.dto.EmployeeDTO;
import com.anudip.empsystem.exception.ResourceNotFoundException;
import com.anudip.empsystem.model.Department;
import com.anudip.empsystem.model.Employee;
import com.anudip.empsystem.repository.DepartmentRepository;
import com.anudip.empsystem.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository empRepo;
    private final DepartmentRepository deptRepo;

    public EmployeeServiceImpl(EmployeeRepository empRepo, DepartmentRepository deptRepo) {
        this.empRepo = empRepo;
        this.deptRepo = deptRepo;
    }

    private Employee mapDtoToEntity(EmployeeDTO dto) {
        Employee e = new Employee();
        e.setName(dto.getName());
        e.setDesignation(dto.getDesignation());
        e.setEmail(dto.getEmail());
        e.setSalary(dto.getSalary());
        if (dto.getDepartmentId() != null) {
            Department d = deptRepo.findById(dto.getDepartmentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Department not found: " + dto.getDepartmentId()));
            e.setDepartment(d);
        }
        return e;
    }

    private void updateEntityWithDto(Employee e, EmployeeDTO dto) {
        e.setName(dto.getName());
        e.setDesignation(dto.getDesignation());
        e.setEmail(dto.getEmail());
        e.setSalary(dto.getSalary());
        if (dto.getDepartmentId() != null) {
            Department d = deptRepo.findById(dto.getDepartmentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Department not found: " + dto.getDepartmentId()));
            e.setDepartment(d);
        } else {
            e.setDepartment(null);
        }
    }

    @Override
    public Employee createEmployee(EmployeeDTO dto) {
        Optional<Employee> exists = empRepo.findByEmail(dto.getEmail());
        if (exists.isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }
        Employee e = mapDtoToEntity(dto);
        return empRepo.save(e);
    }

    @Override
    public Employee updateEmployee(Long id, EmployeeDTO dto) {
        Employee e = empRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found: " + id));
        updateEntityWithDto(e, dto);
        return empRepo.save(e);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return empRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found: " + id));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee e = empRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found: " + id));
        empRepo.delete(e);
    }
}
