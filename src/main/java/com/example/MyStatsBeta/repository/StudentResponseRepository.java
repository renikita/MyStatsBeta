package com.example.MyStatsBeta.repository;


import com.example.MyStatsBeta.model.Homework;
import com.example.MyStatsBeta.model.Student;
import com.example.MyStatsBeta.model.StudentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentResponseRepository extends JpaRepository<StudentResponse, Integer> {

    @Query("SELECT sr FROM StudentResponse sr WHERE sr.student = :student AND sr.homework = :homework")
    List<StudentResponse> findResponsesByStudentAndHomework(@Param("student") Student student, @Param("homework") Homework homework);

    @Query("SELECT sr FROM StudentResponse sr WHERE sr.student = :student")
    List<StudentResponse> findAllResponsesByStudent(@Param("student") Student student);


    @Query("SELECT sr FROM StudentResponse sr WHERE sr.student = :student AND sr.homework = :homework")
    StudentResponse findByStudentAndHomework(@Param("student") Student student, @Param("homework") Homework homework);
}
