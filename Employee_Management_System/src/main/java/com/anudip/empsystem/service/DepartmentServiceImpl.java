package com.anudip.empsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anudip.empsystem.dto.DepartmentDTO;
import com.anudip.empsystem.exception.ResourceNotFoundException;
import com.anudip.empsystem.model.Department;
import com.anudip.empsystem.repository.DepartmentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{

	private final DepartmentRepository deptRepo;

    public DepartmentServiceImpl(DepartmentRepository deptRepo) {
        this.deptRepo = deptRepo;
    }

    private Department mapDtoToEntity(DepartmentDTO dto) {
        Department d = new Department();
        d.setName(dto.getName());
        d.setLocation(dto.getLocation());
        return d;
    }

    @Override
    public Department createDepartment(DepartmentDTO dto) {
        Department d = mapDtoToEntity(dto);
        return deptRepo.save(d);
    }

    @Override
    public Department updateDepartment(Long id, DepartmentDTO dto) {
        Department existing = deptRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found: " + id));
        existing.setName(dto.getName());
        existing.setLocation(dto.getLocation());
        return deptRepo.save(existing);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return deptRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found: " + id));
    }

    @Override
    public List<Department> getAllDepartments() {
        return deptRepo.findAll();
    }

    @Override
    public void deleteDepartment(Long id) {
        Department d = deptRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found: " + id));
        deptRepo.delete(d);
    }
}
