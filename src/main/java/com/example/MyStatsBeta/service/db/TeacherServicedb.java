package com.example.MyStatsBeta.service.db;

import com.example.MyStatsBeta.model.Student;
import com.example.MyStatsBeta.model.Teacher;
import com.example.MyStatsBeta.repository.StudentRepository;
import com.example.MyStatsBeta.repository.TeacherRepository;
import com.example.MyStatsBeta.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServicedb implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public Teacher
 save(Teacher Teacher) {
        return teacherRepository.save(Teacher);
    }
    @Override
    public Teacher findById(Integer id){
        return teacherRepository.findById(id).get();
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public List<Teacher> saveAllAndFlush(Iterable<Teacher> teachers){
        throw new RuntimeException("Not Supported");
    }

}
