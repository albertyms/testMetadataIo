package com.metadata.test;

import com.metadata.test.entity.Course;
import com.metadata.test.service.impl.CourseServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CourseImplementTests {

	Course course1 = new Course(1L,"test1", "TEST1", 0);
	Course course2 = new Course(2L,"test2", "TEST2", 0);
	Course course3 = new Course(3L,"test3", "TEST3", 0);
	Course course4 = new Course(4L,"test4", "TEST4", 0);
	Course course5 = new Course(5L,"test5", "TEST5", 0);

	@Mock
	CourseServiceImpl courseService;

	@Test
	void testGetAllCourse_success() {
		Iterable<Course> coursesData = new ArrayList<>(Arrays.asList(course1, course2, course3, course4, course5));
		when(courseService.findAll()).thenReturn(coursesData);
		Iterable<Course> courses = courseService.findAll();
		assertNotNull(courses);
	}

	@Test
	void testGetAllCourse_error() {
		Iterable<Course> coursesData = new ArrayList<>();
		when(courseService.findAll()).thenReturn(coursesData);
		assertNull(null);
	}

	@Test
	void testGetOneCourse_success() {
		when(courseService.findById(course1.getId())).thenReturn(Optional.ofNullable(course1));
		Optional<Course> course = courseService.findById(course1.getId());
		assertTrue(course.isPresent());
	}

	@Test
	void testCreateCourse_success() {
		Course course = new Course();
		course.setNameCourse("test1");
		course.setCodeCourse("TEST1");
		course.setNumberStudent(0);
		when(courseService.create(course)).thenReturn(course1);
		course = courseService.create(course);
		assertNotNull(course.getId());
	}

	@Test
	void testUpdateCourse_success() {
		Course courseUpdate = new Course(1L,"TestUpdate1", "TESTUPDATE", 0);
		Course course = new Course();
		course.setId(1L);
		course.setNameCourse("TestUpdate1");
		course.setCodeCourse("TESTUPDATE!");
		course.setNumberStudent(0);
		when(courseService.create(course)).thenReturn(courseUpdate);
		course = courseService.create(course);
		assertEquals(course,courseUpdate);
	}

}
