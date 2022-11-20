package com.restapi.springbootrestapi.controller;

import com.restapi.springbootrestapi.entities.Student;
import com.restapi.springbootrestapi.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/students")
@RestController
public class Controller {

    @Autowired //injects the impl class without creating an object
    private StudentService studentService;

    //get list of students
    @GetMapping()
    public ResponseEntity<Object> getStudents() {
//        calls using runtime polymorphism goes to interface but using runtime polymorphism it goes to impl class
        try {
            return this.studentService.getStudents();
        } catch (Exception e) {
            return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{studentId}")
    public ResponseEntity<Object> getStudent(@PathVariable Long studentId) {
        try {
            return this.studentService.getStudent(studentId);
        } catch (Exception e) {
            return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<Object> getStudentsByName(@RequestParam("name") String studentName) {
    try {
            return this.studentService.getStudentsByName(studentName);
        } catch (Exception e) {
            return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "addStudent")
    public ResponseEntity<Object> addStudent(@RequestBody Student student) {
        return this.studentService.addStudent(student);
    }

    @PutMapping(path = "{studentId}", consumes = "application/json")
    public ResponseEntity<Object> updateStudent(@PathVariable Long studentId,@RequestBody Student student)
    {
        try {
            return this.studentService.updateStudent(studentId,student);
        } catch (Exception e) {
            return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("{studentId}")
    public ResponseEntity<Object> deleteStudent(@PathVariable Long studentId) {
        try {
            return this.studentService.deleteStudent(studentId);
        } catch (Exception e) {
            return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


//    @DeleteMapping("/delete")
//    public ResponseEntity<Object> deleteStudentsByName(@RequestParam("name") String studentName) {
//        try {
//            return this.studentService.deleteStudentsByName(studentName);
//        } catch (Exception e) {
//            return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
