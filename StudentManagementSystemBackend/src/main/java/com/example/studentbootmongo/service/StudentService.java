

package com.example.studentbootmongo.service;


import com.example.studentbootmongo.exception.FieldNotEmpty;
import com.example.studentbootmongo.model.Student;

import java.util.List;

public interface StudentService {


    List<Student> getAllStudents(); // public + abstract

    Student saveUser(Student student) throws FieldNotEmpty;


    List<Student> saveallUser(List<Student> student);

    //Object getProductById(String studentId);
    Student getProductById(String Id);

    Student updatestudent(Student student);

void deleteProduct(String productId) ;
}
