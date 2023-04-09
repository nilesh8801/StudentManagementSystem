


package com.example.studentbootmongo;



import com.example.studentbootmongo.exception.FieldNotEmpty;
import com.example.studentbootmongo.exception.UserInActive;
import com.example.studentbootmongo.model.Student;
import com.example.studentbootmongo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {

    @Autowired
    StudentService studentService;



//  GET Student
//   @GetMapping("/students")
//   public List<Student> getAllStudents(Student student) {
//
//       return studentService.getAllStudents();
//   }


    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> studd =  this.studentService.getAllStudents();
        return new  ResponseEntity<List<Student>>(studd, HttpStatus.OK);

    }



//Add student
//    @PostMapping("/students")
//    public String saveUser(@RequestBody Student student) {
//        studentService.saveUser(student);
//        return "User saved successfully..." ;
//    }

    @PostMapping("/students")
    public ResponseEntity<Student> saveUser(@RequestBody Student student) throws FieldNotEmpty {
    Student stud= this.studentService.saveUser(student);
        return new ResponseEntity<Student>(stud, HttpStatus.CREATED);
    }

//Add multiple student at time

    @PostMapping("/addmultiplestudent")
    public ResponseEntity<List<Student>> savemultipleuser(@RequestBody List<Student> student){
       List<Student> studmultple= this.studentService.saveallUser(student);
        return new  ResponseEntity<List<Student>>(studmultple, HttpStatus.CREATED);
    }


//get single student
//    @GetMapping("/students/{id}")
//    public ResponseEntity<Object> getProductById(@PathVariable String id) {
//
//        return ResponseEntity.ok().body(studentService.getProductById(id));
//    }
       @GetMapping("/students/{id}")
       public ResponseEntity<Object> getProductById(@PathVariable String id) {
       Student student =  this.studentService.getProductById(id);
      return ResponseEntity.ok().body(student);
       }





    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updatestudent(@PathVariable String id, @RequestBody Student student){
        student.setId(id);
       Student s= this.studentService.updatestudent( student);
        return ResponseEntity.ok().body(s);
    }

// deleted user
//    @DeleteMapping("/students/{id}")
//    public HttpStatus deleteProduct(@PathVariable String  id){
//        this.studentService.deleteProduct(id);
//        return HttpStatus.OK;
//    }


    @DeleteMapping("/students/{id}")   //
    public ResponseEntity<String> deleteProduct(@PathVariable String id)  {
           this.studentService.deleteProduct(id);
        return new ResponseEntity<String>("Student deleted successfully...", HttpStatus.OK );
    }



}
