package com.restapi.springbootrestapi.dao;

import com.restapi.springbootrestapi.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentDao extends JpaRepository<Student, Long> {
//    @Query(value = "SELECT s FROM Student s WHERE s.name=?1")
    List<Student> findByName(String studentName);

//    @Query("SELECT e FROM EMP e WHERE e.id =:id ")
//EMP getById(@Param("id") String id);

//    @Query(value = "DELETE s FROM Student s WHERE s.name=?1")
//    void deleteByName(String studentName);
}
