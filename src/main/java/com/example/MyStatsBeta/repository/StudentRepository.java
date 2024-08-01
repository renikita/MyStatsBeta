package com.example.MyStatsBeta.repository;

import com.example.MyStatsBeta.model.Homework;
import com.example.MyStatsBeta.model.Student;
import com.example.MyStatsBeta.model.StudentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByLogin(String login);

    @Query("SELECT sr FROM Student sr WHERE sr.name = :name")
    Student findByName(String name);
}
