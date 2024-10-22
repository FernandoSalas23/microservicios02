package com.colegio.student_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.colegio.student_service.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByName(String name);
}

