package com.metadata.test;

import com.metadata.test.entity.Course;
import com.metadata.test.entity.Student;
import com.metadata.test.entity.StudentCourse;
import com.metadata.test.service.impl.StudentCourseServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class StudentCourseTests {

    Student student1 = new Student(1L, "Albert Medina1", 1234561L);
    Student student2 = new Student(2L, "Albert Medina2", 1234562L);
    Student student3 = new Student(3L, "Albert Medina3", 1234563L);
    Student student4 = new Student(4L, "Albert Medina4", 1234564L);
    Student student5 = new Student(5L, "Albert Medina5", 1234565L);

    Course course1 = new Course(1L,"test1", "TEST1", 0);
    Course course2 = new Course(2L,"test2", "TEST2", 0);
    Course course3 = new Course(3L,"test3", "TEST3", 0);
    Course course4 = new Course(4L,"test4", "TEST4", 0);
    Course course5 = new Course(5L,"test5", "TEST5", 0);

    StudentCourse studentCourse1 = new StudentCourse(1L, student1, course1);

    StudentCourse studentCourse11 = new StudentCourse(1L, student1, course1);
    StudentCourse studentCourse12 = new StudentCourse(1L, student1, course2);
    StudentCourse studentCourse13 = new StudentCourse(1L, student1, course3);
    StudentCourse studentCourse14 = new StudentCourse(1L, student1, course4);
    StudentCourse studentCourse15 = new StudentCourse(1L, student1, course5);

    StudentCourse studentCourse21 = new StudentCourse(1L, student2, course1);
    StudentCourse studentCourse31 = new StudentCourse(1L, student3, course1);
    StudentCourse studentCourse41 = new StudentCourse(1L, student4, course1);
    StudentCourse studentCourse51 = new StudentCourse(1L, student5, course1);

    @Mock
    StudentCourseServiceImpl service;

    @Test
    void testCreateCourse_success() {
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setStudent(student1);
        studentCourse.setCourse(course1);
        when(service.create(studentCourse)).thenReturn(studentCourse1);
        studentCourse = service.create(studentCourse);
        assertNotNull(studentCourse.getId());
    }

    @Test
    void testFindByStudent() {
        Iterable<StudentCourse> studentCoursesData = new ArrayList<>(Arrays.asList(studentCourse11, studentCourse12, studentCourse13, studentCourse14, studentCourse15));
        when(service.findByStudent(student1)).thenReturn(studentCoursesData);
        Iterable<StudentCourse> studentCourses = service.findByStudent(student1);
        assertNotNull(studentCourses);
    }

    @Test
    void testFindByCourse() {
        Iterable<StudentCourse> studentCoursesData = new ArrayList<>(Arrays.asList(studentCourse11, studentCourse21, studentCourse31, studentCourse41, studentCourse51));
        when(service.findByCourse(course1)).thenReturn(studentCoursesData);
        Iterable<StudentCourse> studentCourses = service.findByCourse(course1);
        assertNotNull(studentCourses);
    }

}
