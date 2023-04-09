package com.example.studentbootmongo.repository;

import com.example.studentbootmongo.model.Student;

import com.sun.org.apache.xpath.internal.operations.Number;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, String>{


    Optional<Student> findById(Student Id);

    List<Student> findByEnabled(Boolean b);
}
