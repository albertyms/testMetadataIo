package com.metadata.test.service.impl;

import com.metadata.test.entity.Course;
import com.metadata.test.entity.Student;
import com.metadata.test.entity.StudentCourse;
import com.metadata.test.repository.CourseRepository;
import com.metadata.test.repository.StudentCourseRepository;
import com.metadata.test.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

    @Autowired
    StudentCourseRepository repository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public StudentCourse create(StudentCourse studentCourse) {
        StudentCourse studentCourseEntity = repository.save(studentCourse);
        Course course = studentCourse.getCourse();
        course.setNumberStudent(studentCourse.getCourse().getNumberStudent() + 1);
        course = courseRepository.save(course);
        studentCourse.setCourse(course);
        return studentCourseEntity;
    }

    @Override
    public StudentCourse update(StudentCourse studentCourse) {
        return repository.save(studentCourse);
    }

    @Override
    public Optional<StudentCourse> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(StudentCourse studentCourse) {
        repository.delete(studentCourse);
    }

    @Override
    public Iterable<StudentCourse> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<StudentCourse> findByStudentAndCourse(Student student, Course course) {
        return repository.findByStudentAndCourse(student, course);
    }

    @Override
    public Integer numCourseByStudent(Student student) {
        return repository.countByStudent(student);
    }

    @Override
    public Iterable<StudentCourse> findByStudent(Student student) {
        return repository.findByStudent(student);
    }

    @Override
    public Iterable<StudentCourse> findByCourse(Course course) {
        return repository.findByCourse(course);
    }
}
