package com.restapi.springbootrestapi.services;

import com.restapi.springbootrestapi.dao.StudentDao;
import com.restapi.springbootrestapi.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;

    public StudentServiceImpl() {
    }
    @Override
    public ResponseEntity getStudents(){
        if (studentDao.count() != 0) {
            return new ResponseEntity(studentDao.findAll(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity("No students", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity getStudent(Long studentId) {
        if (studentDao.existsById(studentId)) {
            return new ResponseEntity(studentDao.findById(studentId).get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity("No student with this id", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity addStudent(Student student) {
        studentDao.save(student);
        return new ResponseEntity(student, HttpStatus.OK);
    }

    @Override
    public ResponseEntity updateStudent(Long studentId, Student student) {
        Optional<Student> currentStudent = studentDao.findById(studentId);
        if(currentStudent.isPresent()) {
            Student _student = currentStudent.get();
            if(student.getName() != null) _student.setName(student.getName());
            if(student.getPhone() != null) _student.setPhone(student.getPhone());
            if(student.getCode() != null) _student.setCode(student.getCode());
            return new ResponseEntity<>(studentDao.save(_student), HttpStatus.OK);
        } else {
            return new ResponseEntity("Student with this id doesn't exist", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity deleteStudent(Long studentId) {
        if (studentDao.existsById(studentId)) {
            studentDao.deleteById(studentId);
            return new ResponseEntity("Student deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity("Id doesn't exist", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity getStudentsByName(String studentName) {
        List<Student> currentStudents = studentDao.findByName(studentName);
        return new ResponseEntity(currentStudents, HttpStatus.OK);
//        if (currentStudent != null) {
//            return new ResponseEntity(currentStudent, HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity("No student with this id", HttpStatus.NOT_FOUND);
//        }
    }

//    @Override
//    public ResponseEntity deleteStudentsByName(String studentName) {
//        studentDao.deleteByName(studentName);
//        return new ResponseEntity("Students deleted successfully", HttpStatus.OK);
//    }


}
