package com.metadata.test.repository;

import com.metadata.test.entity.Course;
import com.metadata.test.entity.Student;
import com.metadata.test.entity.StudentCourse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentCourseRepository extends CrudRepository<StudentCourse, Long> {

    Optional<StudentCourse> findByStudentAndCourse(Student student, Course course);

    Integer countByStudent(Student student);

}
