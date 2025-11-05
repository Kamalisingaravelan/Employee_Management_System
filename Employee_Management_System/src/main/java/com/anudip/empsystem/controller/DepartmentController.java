package com.anudip.empsystem.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.empsystem.dto.DepartmentDTO;
import com.anudip.empsystem.model.Department;
import com.anudip.empsystem.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService deptService;

    public DepartmentController(DepartmentService deptService) {
        this.deptService = deptService;
    }

    // ✅ Create Department
    @PostMapping
    public ResponseEntity<Department> create(@Valid @RequestBody DepartmentDTO dto) {
        Department created = deptService.createDepartment(dto);
        return ResponseEntity.created(URI.create("/api/departments/" + created.getId())).body(created);
    }

    // ✅ Get All Departments
    @GetMapping
    public ResponseEntity<List<Department>> getAll() {
        return ResponseEntity.ok(deptService.getAllDepartments());
    }

    // ✅ Get Department by ID
    @GetMapping("/{id}")
    public ResponseEntity<Department> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(deptService.getDepartmentById(id));
    }

    // ✅ Update Department by ID
    @PutMapping("/{id}")
    public ResponseEntity<Department> update(@PathVariable("id") Long id, @Valid @RequestBody DepartmentDTO dto) {
        return ResponseEntity.ok(deptService.updateDepartment(id, dto));
    }

    // ✅ Delete Department by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        deptService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}
