package com.example.MyStatsBeta.repository;

import com.example.MyStatsBeta.model.Homework;
import com.example.MyStatsBeta.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeworkRepository extends JpaRepository<Homework, Integer> {


    List<Homework> findByStudentsIn(List<Student> students);
}
