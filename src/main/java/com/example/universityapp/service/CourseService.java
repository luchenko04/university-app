package com.example.universityapp.service;

import com.example.universityapp.entity.Course;
import com.example.universityapp.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public void delete(Long id) {
        courseRepository.deleteById(id);
    }
}