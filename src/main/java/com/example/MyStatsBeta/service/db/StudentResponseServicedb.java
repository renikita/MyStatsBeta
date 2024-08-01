package com.example.MyStatsBeta.service.db;


import com.example.MyStatsBeta.model.Homework;
import com.example.MyStatsBeta.model.Student;
import com.example.MyStatsBeta.model.StudentResponse;
import com.example.MyStatsBeta.repository.StudentResponseRepository;
import com.example.MyStatsBeta.service.response.StudentResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentResponseServicedb implements StudentResponseService {

    @Autowired
    StudentResponseRepository studentResponseRepository;
    @Override
    public void saveResponse(StudentResponse response) {
        studentResponseRepository.save(response);
    }

    @Override
    public List<StudentResponse> findResponsesByStudentAndHomework(Student student, Homework homework) {
        return studentResponseRepository.findResponsesByStudentAndHomework(student, homework);
    }

    @Override
    public List<StudentResponse> findAllResponsesByStudent(Student student) {
        return studentResponseRepository.findAllResponsesByStudent(student);
    }

    @Override
    public StudentResponse findByStudentAndHomework(Student student, Homework homework) {
        return studentResponseRepository.findByStudentAndHomework(student, homework);
    }

    @Override
    public StudentResponse findByStudent(Student student) {
        return null;
    }

    @Override
    public StudentResponse findByHomework(Homework homework) {
        return null;
    }


}
