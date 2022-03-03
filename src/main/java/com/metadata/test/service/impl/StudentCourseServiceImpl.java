package com.metadata.test.service.impl;

import com.metadata.test.entity.Course;
import com.metadata.test.entity.Student;
import com.metadata.test.entity.StudentCourse;
import com.metadata.test.repository.CourseRepository;
import com.metadata.test.repository.StudentCourseRepository;
import com.metadata.test.service.StudentCourseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {
    private final Logger logger = LogManager.getLogger(StudentCourseServiceImpl.class);
    static final String ERROR_PROCESS = "Error: ";

    @Autowired
    StudentCourseRepository repository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public StudentCourse create(StudentCourse studentCourse) {
        try {
            StudentCourse studentCourseEntity = repository.save(studentCourse);
            Course course = studentCourse.getCourse();
            course.setNumberStudent(studentCourse.getCourse().getNumberStudent() + 1);
            course = courseRepository.save(course);
            studentCourse.setCourse(course);
            return studentCourseEntity;
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
            return null;
        }
    }

    @Override
    public StudentCourse update(StudentCourse studentCourse) {
        try {
            return repository.save(studentCourse);
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
            return null;
        }
    }

    @Override
    public Optional<StudentCourse> findById(Long id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
            return Optional.empty();
        }
    }

    @Override
    public void delete(StudentCourse studentCourse) {
        try {
            repository.delete(studentCourse);
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
        }
    }

    @Override
    public Iterable<StudentCourse> findAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
            return null;
        }
    }

    @Override
    public Optional<StudentCourse> findByStudentAndCourse(Student student, Course course) {
        try {
            return repository.findByStudentAndCourse(student, course);
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
            return Optional.empty();
        }
    }

    @Override
    public Integer numCourseByStudent(Student student) {
        try {
            return repository.countByStudent(student);
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
            return null;
        }
    }
}
