package com.metadata.test.service.impl;

import com.metadata.test.entity.Course;
import com.metadata.test.repository.CourseRepository;
import com.metadata.test.request.CourseRequest;
import com.metadata.test.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository repository;

    @Override
    public Course create(Course course) {
        return repository.save(course);
    }

    @Override
    public Course update(Course course) {
        return repository.save(course);
    }

    @Override
    public Optional<Course> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Course course) {
        repository.delete(course);
    }

    @Override
    public Iterable<Course> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Course> findByNameCourseAndCodeCourse(CourseRequest request) {
        if (request.getCodeCourse() != null) {
            return repository.findByNameCourseAndCodeCourse(request.getNameCourse(), request.getCodeCourse());
        } else {
            return repository.findByNameCourse(request.getNameCourse());
        }
    }
}
