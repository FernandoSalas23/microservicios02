package com.colegio.student_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegio.student_service.entity.Student;
import com.colegio.student_service.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        student.setName(studentDetails.getName());
        student.setGrade(studentDetails.getGrade());
        student.setEnrollmentDate(studentDetails.getEnrollmentDate());
        return studentRepository.save(student);
    }

    public List<Student> getStudentsByName(String name) {
        return studentRepository.findByName(name);
    }
    
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}

