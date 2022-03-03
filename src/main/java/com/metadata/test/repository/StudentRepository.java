package com.metadata.test.repository;

import com.metadata.test.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    Optional<Student> findByFullNameAndNumberId(String fullName, Long numberId);

    Optional<Student> findByFullName(String name);

}
