package com.metadata.test.service.impl;

import com.metadata.test.entity.Student;
import com.metadata.test.repository.StudentRepository;
import com.metadata.test.request.StudentRequest;
import com.metadata.test.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final Logger logger = LogManager.getLogger(StudentServiceImpl.class);
    static final String ERROR_PROCESS = "Error: ";

    @Autowired
    StudentRepository repository;

    @Override
    public Student create(Student student) {
        try {
            return repository.save(student);
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
            return null;
        }
    }

    @Override
    public Student update(Student student) {
        try {
            return repository.save(student);
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
            return null;
        }
    }

    @Override
    public Optional<Student> findById(Long id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
            return Optional.empty();
        }
    }

    @Override
    public void delete(Student student) {
        try {
            repository.delete(student);
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
        }
    }

    @Override
    public Iterable<Student> findAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            logger.error(ERROR_PROCESS, e);
            return null;
        }
    }

    @Override
    public Optional<Student> findByFullNameAndNumberId(StudentRequest request) {
        if(request.getNumberId() != null) {
            return repository.findByFullNameAndNumberId(request.getFullName(), request.getNumberId());
        } else {
            return repository.findByFullName(request.getFullName());
        }
    }
}
