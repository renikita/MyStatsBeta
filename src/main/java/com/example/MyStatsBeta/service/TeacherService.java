package com.example.MyStatsBeta.service;

import com.example.MyStatsBeta.model.Student;
import com.example.MyStatsBeta.model.Teacher;
import com.example.MyStatsBeta.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {

    Teacher save(Teacher Teacher);

    Teacher findById(Integer id);

    public List<Teacher> findAll();

    public List<Teacher> saveAllAndFlush(Iterable<Teacher> teachers);


}
