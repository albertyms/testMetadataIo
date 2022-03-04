package com.metadata.test.service.impl;

import com.metadata.test.entity.Student;
import com.metadata.test.repository.StudentRepository;
import com.metadata.test.request.StudentRequest;
import com.metadata.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repository;

    @Override
    public Student create(Student student) {
        return repository.save(student);
    }

    @Override
    public Student update(Student student) {
        return repository.save(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Student student) {
        repository.delete(student);
    }

    @Override
    public Iterable<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Student> findByFullNameAndNumberId(StudentRequest request) {
        if (request.getNumberId() != null) {
            return repository.findByFullNameAndNumberId(request.getFullName(), request.getNumberId());
        } else {
            return repository.findByFullName(request.getFullName());
        }
    }
}
