package com.example.universityapp.service;

import com.example.universityapp.entity.Student;
import com.example.universityapp.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}