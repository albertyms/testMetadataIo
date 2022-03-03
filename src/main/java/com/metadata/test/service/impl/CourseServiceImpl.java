package com.metadata.test.service.impl;

import com.metadata.test.entity.Course;
import com.metadata.test.repository.CourseRepository;
import com.metadata.test.request.CourseRequest;
import com.metadata.test.service.CourseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    private final Logger logger = LogManager.getLogger(CourseServiceImpl.class);
    static final String ERROR_PROCESS = "Error: ";

    @Autowired
    CourseRepository repository;

    @Override
    public Course create(Course course) {
        try {
            return repository.save(course);
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
            return null;
        }
    }

    @Override
    public Course update(Course course) {
        try {
            return repository.save(course);
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
            return null;
        }
    }

    @Override
    public Optional<Course> findById(Long id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
            return Optional.empty();
        }
    }

    @Override
    public void delete(Course course) {
        try {
            repository.delete(course);
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
        }
    }

    @Override
    public  Iterable<Course> findAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
            return null;
        }
    }

    @Override
    public Optional<Course> findByNameCourseAndCodeCourse(CourseRequest request) {
        try {
            if(request.getCodeCourse() != null) {
                return repository.findByNameCourseAndCodeCourse(request.getNameCourse(), request.getCodeCourse());
            } else {
                return repository.findByNameCourse(request.getNameCourse());
            }
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
            return Optional.empty();
        }
    }
}
