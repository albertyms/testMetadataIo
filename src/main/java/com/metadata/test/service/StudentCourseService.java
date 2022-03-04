package com.metadata.test.service;

import com.metadata.test.entity.Course;
import com.metadata.test.entity.Student;
import com.metadata.test.entity.StudentCourse;

import java.util.Optional;

public interface StudentCourseService {

    StudentCourse create(StudentCourse studentCourse);

    StudentCourse update(StudentCourse studentCourse);

    Optional<StudentCourse> findById(Long id);

    void delete(StudentCourse studentCourse);

    Iterable<StudentCourse> findAll();

    Optional<StudentCourse> findByStudentAndCourse(Student student, Course course);

    Integer numCourseByStudent(Student student);

    Iterable<StudentCourse> findByStudent(Student student);

    Iterable<StudentCourse> findByCourse(Course course);

}
