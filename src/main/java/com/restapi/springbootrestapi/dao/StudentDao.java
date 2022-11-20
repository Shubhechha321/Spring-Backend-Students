package com.restapi.springbootrestapi.dao;

import com.restapi.springbootrestapi.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentDao extends JpaRepository<Student, Long> {
//    @Query(value = "SELECT s FROM Student s WHERE s.name=?1")
    List<Student> findByName(String studentName);

//    @Query("SELECT e FROM EMP e WHERE e.id =:id ")
//EMP getById(@Param("id") String id);
    @Modifying
    @Query("DELETE FROM Student WHERE name = :name")
    void deleteByName(String name);


    @Query("select s from Student s where s.name = :#{#req.name} and s.code = :#{#req.code}")
    Optional<Student> findStudent(@Param("req") Student req);
}
