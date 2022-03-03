package com.metadata.test.controller;

import com.metadata.test.entity.Course;
import com.metadata.test.request.CourseRequest;
import com.metadata.test.service.impl.CourseServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/course")
@Validated
public class CourseController {
    private final Logger logger = LogManager.getLogger(CourseController.class);
    static final String ERROR_PROCESS = "Error: ";
    static final String ERROR_REQUEST = "Error trying to process the request: ";

    @Autowired
    CourseServiceImpl service;

    @PostMapping
    public ResponseEntity<Object> create(@Validated @RequestBody CourseRequest request) {
        try {
            if(service.findByNameCourseAndCodeCourse(request).isPresent()) {
                return new ResponseEntity<>("This course already exists", HttpStatus.PRECONDITION_FAILED);
            } else {
                Course course = new Course();
                course.setNameCourse(request.getNameCourse());
                course.setCodeCourse(request.getCodeCourse());
                course.setNumberStudent(0);
                return ResponseEntity.ok(service.create(course));
            }
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
            return new ResponseEntity<>(ERROR_REQUEST, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @Validated @RequestBody CourseRequest request) {
        try {
            Optional<Course> course = service.findById(id);
            if(course.isPresent()) {
                course.get().setCodeCourse(request.getCodeCourse());
                course.get().setNameCourse(request.getNameCourse());
                return ResponseEntity.ok(service.update(course.get()));
            } else {
                return new ResponseEntity<>(ERROR_REQUEST, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
            return new ResponseEntity<>(ERROR_REQUEST, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            Optional<Course> course = service.findById(id);
            return course.<ResponseEntity<Object>>map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>("This course not exists", HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
            return new ResponseEntity<>(ERROR_REQUEST, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Course>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        try {
            Optional<Course> course = service.findById(id);
            if (course.isPresent()) {
                service.delete(course.get());
                return new ResponseEntity<>(course, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
            return new ResponseEntity<>(ERROR_REQUEST, HttpStatus.BAD_REQUEST);
        }
    }

}
