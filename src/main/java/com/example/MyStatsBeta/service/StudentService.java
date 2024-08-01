package com.example.MyStatsBeta.service;

import com.example.MyStatsBeta.model.Homework;
import com.example.MyStatsBeta.model.Student;
import com.example.MyStatsBeta.model.StudentResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

  Student save(Student student);


  Student findById(Integer id);

  Student findByName(String name);

  Student ChangeName(String nameBefore, String nameAfter);

  List<Student> findAll();


  List<Student> saveAllAndFlush(Iterable<Student> students);

}
