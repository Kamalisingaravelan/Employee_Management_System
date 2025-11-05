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

import com.anudip.empsystem.dto.EmployeeDTO;
import com.anudip.empsystem.model.Employee;
import com.anudip.empsystem.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService empService;

    public EmployeeController(EmployeeService empService) {
        this.empService = empService;
    }

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<Employee> create(@Valid @RequestBody EmployeeDTO dto) {
        Employee created = empService.createEmployee(dto);
        return ResponseEntity.created(URI.create("/api/employees/" + created.getId())).body(created);
    }

    // ✅ READ (ALL)
    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(empService.getAllEmployees());
    }

    // ✅ READ (BY ID)
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(empService.getEmployeeById(id));
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") Long id, @Valid @RequestBody EmployeeDTO dto) {
        return ResponseEntity.ok(empService.updateEmployee(id, dto));
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        empService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
