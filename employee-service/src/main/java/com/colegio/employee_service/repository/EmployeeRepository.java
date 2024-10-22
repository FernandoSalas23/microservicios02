package com.colegio.employee_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.colegio.employee_service.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByRole(String role);
}

