package com.example.MyStatsBeta.repository;

import com.example.MyStatsBeta.model.Student;
import com.example.MyStatsBeta.model.Teacher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    public boolean authenticate(String login, String password) {

        Teacher teacher = teacherRepository.findByLogin(login);
        Student student = studentRepository.findByLogin(login);


        return (teacher != null && teacher.getPassword().equals(password)) ||
                (student != null && student.getPassword().equals(password));
    }

    public String getUserRole(String login) {
        Teacher teacher = teacherRepository.findByLogin(login);
        if (teacher != null) {
            return "TEACHER";
        }

        Student student = studentRepository.findByLogin(login);
        if (student != null) {
            return "STUDENT";
        }

        return null;
    }
}
