

package com.example.studentbootmongo.service;


import com.example.studentbootmongo.exception.FieldNotEmpty;
import com.example.studentbootmongo.exception.ResourceNotFoundExceptions;
import com.example.studentbootmongo.exception.UserInActive;
import com.example.studentbootmongo.model.Student;
import com.example.studentbootmongo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;


    @Override
    public List<Student> getAllStudents() {
        List<Student> stud = this.studentRepository.findByEnabled(true);
        return stud;


    }

    @Override
    public Student saveUser(Student student) throws FieldNotEmpty {
        Student stud = studentRepository.save(student);
        if (stud.getFirstname().equals("") || stud.getLastname().equals("") ||
                stud.getEmail().equals("") || stud.getMobile() == null) {
            System.out.println("plz enter valid details");

            throw new FieldNotEmpty("filed should not empty....!!!!!");

        } else {
            return stud;
        }
    }

    @Override
    public List<Student> saveallUser(List<Student> student) {
        List<Student> sud = (List<Student>) this.studentRepository.saveAll(student);
        return sud;
    }


    @Override
    public Student getProductById(String Id) {

        Optional<Student> studentdb = this.studentRepository.findById(Id);

        if (studentdb.isPresent()) {
            return studentdb.get();
        } else {
            throw new ResourceNotFoundExceptions(" Student  ", "id", Id);
        }
    }


    @Override
    public Student updatestudent(Student student) {
        Optional<Student> students = this.studentRepository.findById(student.getId());

        if (students.isPresent()) {
            Student stud = students.get();

            stud.setId(student.getId());
            stud.setFirstname(student.getFirstname());
            stud.setLastname(student.getLastname());
            stud.setEmail(student.getEmail());
            stud.setMobile(student.getMobile());
            studentRepository.save(stud);
            return stud;
        } else {

            throw new ResourceNotFoundExceptions(" Student  ", "id", student.getId());
            //  throw new ResourceNotFoundExceptions("RRecord not found with id : " + student.getId());
        }
    }


   @Override
   public void deleteProduct(String productId)  {
        Optional<Student> productDb = this.studentRepository.findById(productId);



       if (productDb.isPresent()) {

            Student studentIsdetail = productDb.get();
              {
                   if (studentIsdetail.isEnabled() == false) {
                         System.out.println("Student is Already inActive......!!!!");
                        throw new UserInActive("Student is Already inActive......!!");
                } else
                      {
                        studentIsdetail.setEnabled(false);
                        this.studentRepository.save(studentIsdetail);

                      }
              }


            }else{
           System.out.println("This student is not present in DB......!!!!");
           throw new UserInActive("this student Id not present in the DB....!!!!! ");
       }
    }}





//    @Override
//    public void deleteProduct(String productId)  {
//        Optional<Student> productDb = this.studentRepository.findById(productId);
//
//
//        if (productDb.isPresent()) {
//            Student studentIsdetail = productDb.get();
//            {
//                if (studentIsdetail.isEnabled() == false) {
//                    System.out.println("Student is Already inActive......!!!!");
//                    throw new UserInActive("Student is Already inActive......!!");
//                } else
//                {
//                    studentIsdetail.setEnabled(false);
//                    this.studentRepository.save(studentIsdetail);
//
//                }
//
//
//            }}}}
//









