package com.anudip.empsystem.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String location;

//    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
//    private List<Employee> employees;

    @JsonIgnore
    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER ,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;
    // ----- Constructors -----
    public Department() {
    }

    public Department(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // ----- Getters and Setters -----
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
