package com.metadata.test.service;

import com.metadata.test.entity.Course;
import com.metadata.test.request.CourseRequest;

import java.util.Optional;

public interface CourseService {

    Course create(Course course);

    Course update(Course course);

    Optional<Course> findById(Long id);

    void delete(Course course);

    Iterable<Course> findAll();

    Optional<Course> findByNameCourseAndCodeCourse(CourseRequest request);
}
