package com.metadata.test.controller;

import com.metadata.test.entity.Course;
import com.metadata.test.entity.Student;
import com.metadata.test.entity.StudentCourse;
import com.metadata.test.request.StudentCourseRequest;
import com.metadata.test.service.impl.CourseServiceImpl;
import com.metadata.test.service.impl.StudentCourseServiceImpl;
import com.metadata.test.service.impl.StudentServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/student-course")
@Validated
public class StudentCourseController {
    private final Logger logger = LogManager.getLogger(StudentCourseController.class);
    static final String ERROR_PROCESS = "Error: ";
    static final String ERROR_REQUEST = "Error trying to process the request: ";
    static final Integer MAX_STUDENTS = 50;
    static final Integer MAX_COURSE_STUDENT = 5;

    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    CourseServiceImpl courseService;

    @Autowired
    StudentCourseServiceImpl studentCourseService;

    @PostMapping
    public ResponseEntity<Object> create(@Validated @RequestBody StudentCourseRequest request) {
        try {
            Optional<Student> student = studentService.findById(request.getIdStudent());
            Optional<Course> course = courseService.findById(request.getIdCourse());
            if(!student.isPresent()) {
                return new ResponseEntity<>("This student not exists", HttpStatus.PRECONDITION_FAILED);
            } else {
                if (studentCourseService.numCourseByStudent(student.get()) >= MAX_COURSE_STUDENT) {
                    return new ResponseEntity<>("The student cannot register more courses", HttpStatus.PRECONDITION_FAILED);
                }
            }
            if(!course.isPresent()) {
                return new ResponseEntity<>("This course not exists", HttpStatus.PRECONDITION_FAILED);
            } else {
                if (course.get().getNumberStudent() >= MAX_STUDENTS) {
                    return new ResponseEntity<>("This course reached its maximum student capacity", HttpStatus.PRECONDITION_FAILED);
                }
            }

            Optional<StudentCourse> studentCourse = studentCourseService.findByStudentAndCourse(student.get(), course.get());
            if(studentCourse.isPresent()) {
                return new ResponseEntity<>("The student has already registered this course", HttpStatus.PRECONDITION_FAILED);
            }

            StudentCourse studentCourseEntity = new StudentCourse();

            studentCourseEntity.setStudent(student.get());
            studentCourseEntity.setCourse(course.get());
            return ResponseEntity.ok(studentCourseService.create(studentCourseEntity));

        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
            return new ResponseEntity<>(ERROR_REQUEST, HttpStatus.BAD_REQUEST);
        }
    }


}
