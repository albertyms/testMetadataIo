package com.metadata.test.service;


import com.metadata.test.entity.Student;
import com.metadata.test.request.StudentRequest;

import java.util.Optional;

public interface StudentService {

    Student create(Student student);

    Student update(Student student);

    Optional<Student> findById(Long id);

    void delete(Student student);

    Iterable<Student> findAll();

    Optional<Student> findByFullNameAndNumberId(StudentRequest student);

}
