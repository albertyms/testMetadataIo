package com.metadata.test.repository;

import com.metadata.test.entity.Course;
import com.metadata.test.entity.Student;
import com.metadata.test.entity.StudentCourse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentCourseRepository extends CrudRepository<StudentCourse, Long> {

    Optional<StudentCourse> findByStudentAndCourse(Student student, Course course);

    Integer countByStudent(Student student);

    @Query("select sc.course from StudentCourse sc inner join Student s on sc.student.id = s.id where sc.student = :student group by sc.course")
    Iterable<StudentCourse> findByStudent(@Param("student") Student student);

    @Query("select sc.student from StudentCourse sc inner join Course c on sc.course.id = c.id where sc.course = :course group by sc.student")
    Iterable<StudentCourse> findByCourse(@Param("course") Course course);
}
