package com.example.universityapp.service;

import com.example.universityapp.entity.Enrollment;
import com.example.universityapp.entity.Student;
import com.example.universityapp.entity.Course;
import com.example.universityapp.repository.EnrollmentRepository;
import com.example.universityapp.repository.StudentRepository;
import com.example.universityapp.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository,
                             StudentRepository studentRepository,
                             CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Enrollment enroll(Long studentId, Long courseId, String semester) {
        Optional<Student> student = studentRepository.findById(studentId);
        Optional<Course> course = courseRepository.findById(courseId);
        if (!studentExists(studentId) || !courseExists(courseId)) {
            throw new IllegalArgumentException("Student or Course not found");
        }
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student.get());
        enrollment.setCourse(course.get());
        enrollment.setSemester(semester);
        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> findByStudentId(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    public void delete(Long id) {
        enrollmentRepository.deleteById(id);
    }

    private boolean studentExists(Long studentId) {
        return studentRepository.existsById(studentId);
    }

    private boolean courseExists(Long courseId) {
        return courseRepository.existsById(courseId);
    }
}