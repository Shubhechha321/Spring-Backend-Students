package com.restapi.springbootrestapi.services;

import com.restapi.springbootrestapi.entities.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    public ResponseEntity getStudents();

    public ResponseEntity getStudent(Long studentId);

    public ResponseEntity addStudent(Student student);

    public ResponseEntity updateStudent(Long studentId, Student student);

    public ResponseEntity deleteStudent(Long studentId);

    public ResponseEntity getStudentsByName(String studentName);

//    public ResponseEntity deleteStudentsByName(String studentName);

//    public List<Student> deleteStudent(Long parseLong);
}
