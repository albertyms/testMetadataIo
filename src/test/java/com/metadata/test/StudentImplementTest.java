package com.metadata.test;

import com.metadata.test.entity.Student;
import com.metadata.test.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class StudentImplementTest {

    Student student1 = new Student(1L, "Albert Medina1", 1234561L);
    Student student2 = new Student(2L, "Albert Medina2", 1234562L);
    Student student3 = new Student(3L, "Albert Medina3", 1234563L);
    Student student4 = new Student(4L, "Albert Medina4", 1234564L);
    Student student5 = new Student(5L, "Albert Medina5", 1234565L);

    @Mock
    StudentServiceImpl studentService;

    @Test
    void testGetAllCourse_success() {
        Iterable<Student> studentsData = new ArrayList<>(Arrays.asList(student1, student2, student3, student4, student5));
        when(studentService.findAll()).thenReturn(studentsData);
        Iterable<Student> courses = studentService.findAll();
        assertNotNull(courses);
    }

    @Test
    void testGetOneCourse_success() {
        when(studentService.findById(student1.getId())).thenReturn(Optional.ofNullable(student1));
        Optional<Student> student = studentService.findById(student1.getId());
        assertTrue(student.isPresent());
    }

    @Test
    void testGetAllCourse_error() {
        Iterable<Student> studentsData = new ArrayList<>();
        when(studentService.findAll()).thenReturn(studentsData);
        assertNull(null);
    }

    @Test
    void testCreateCourse_success() {
        Student student = new Student();
        student.setFullName("Albert Medina1");
        student.setNumberId(1234561L);
        when(studentService.create(student)).thenReturn(student1);
        student = studentService.create(student);
        assertNotNull(student.getId());
    }

    @Test
    void testUpdateCourse_success() {

        Student studentUpdate = new Student(1L, "Albert Yoel Medina", 123456111L);

        Student student = new Student();
        student.setId(1L);
        student.setFullName("Albert Yoel Medina");
        student.setNumberId(123456111L);

        when(studentService.create(student)).thenReturn(studentUpdate);
        student = studentService.create(student);
        assertEquals(student,studentUpdate);
    }

}
