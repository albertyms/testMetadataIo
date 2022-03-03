package com.metadata.test.controller;

import com.metadata.test.entity.Student;
import com.metadata.test.request.StudentRequest;
import com.metadata.test.service.impl.StudentServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/student")
@Validated
public class StudentController {
    private final Logger logger = LogManager.getLogger(StudentController.class);
    static final String ERROR_PROCESS = "Error: ";
    static final String ERROR_REQUEST = "Error trying to process the request: ";

    @Autowired
    StudentServiceImpl service;

    @PostMapping
    public ResponseEntity<Object> create(@Validated @RequestBody StudentRequest request) {
        try {
            if(service.findByFullNameAndNumberId(request).isPresent()) {
                return new ResponseEntity<>("This student already exists", HttpStatus.PRECONDITION_FAILED);
            } else {
                Student student = new Student();
                student.setFullName(request.getFullName());
                student.setNumberId(request.getNumberId());
                return ResponseEntity.ok(service.create(student));
            }
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
            return new ResponseEntity<>(ERROR_REQUEST, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @Validated @RequestBody StudentRequest request) {
        try {
            Optional<Student> student = service.findById(id);
            if(student.isPresent()) {
                student.get().setFullName(request.getFullName());
                student.get().setNumberId(request.getNumberId());
                return ResponseEntity.ok(service.update(student.get()));
            } else {
                return new ResponseEntity<>("This course not exists", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
            return new ResponseEntity<>(ERROR_REQUEST, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            Optional<Student> student = service.findById(id);
            return student.<ResponseEntity<Object>>map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>("This student not exists", HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
            return new ResponseEntity<>(ERROR_REQUEST, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Student>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        try {
            Optional<Student> course = service.findById(id);
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
