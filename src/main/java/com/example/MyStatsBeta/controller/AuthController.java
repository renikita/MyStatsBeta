package com.example.MyStatsBeta.controller;

import com.example.MyStatsBeta.model.Student;
import com.example.MyStatsBeta.model.Teacher;
import com.example.MyStatsBeta.repository.AuthenticationService;
import com.example.MyStatsBeta.repository.StudentRepository;
import com.example.MyStatsBeta.repository.TeacherRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AuthController {

    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    @Autowired
    private AuthenticationService authenticationService;

    public AuthController(TeacherRepository teacherRepository, StudentRepository studentRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }


    @GetMapping("/login")
    public String showLoginForm() {
        return "auth";
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String, String> handleLogin(@RequestParam String login, @RequestParam String password, HttpServletRequest request) {
        Map<String, String> response = new HashMap<>();
        if (authenticationService.authenticate(login, password)) {
            HttpSession session = request.getSession();
            System.out.println(session.toString());
            Teacher teacher = teacherRepository.findByLogin(login);
            Student student = studentRepository.findByLogin(login);
            if (teacher != null) {
                session.setAttribute("role", "TEACHER");
                session.setAttribute("userId", teacher.getId());
                response.put("role", "TEACHER");
                response.put("userId", String.valueOf(teacher.getId()));
            } else if (student != null) {

                session.setAttribute("role", "STUDENT");
                session.setAttribute("userId", student.getId());
                response.put("role", "STUDENT");
                response.put("userId", String.valueOf(student.getId()));
            }
        } else {
            response.put("error", "Incorrect username or password.");
        }
        return response;
    }

}


