package com.example.MyStatsBeta.service;

import com.example.MyStatsBeta.model.Homework;
import com.example.MyStatsBeta.model.Student;

import java.util.List;

public interface HomeworkService {

    Homework save(Homework homework);

    Homework findById(Integer id);

    List<Homework> findAll();

    List<Homework> saveAllAndFlush(Iterable<Homework> students);
}
