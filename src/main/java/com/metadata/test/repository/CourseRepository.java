package com.metadata.test.repository;

import com.metadata.test.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    Optional<Course> findByNameCourseAndCodeCourse(String name, String codeCourse);

    Optional<Course> findByNameCourse(String name);

}
