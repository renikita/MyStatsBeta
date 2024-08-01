package com.example.MyStatsBeta.repository;

import com.example.MyStatsBeta.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findByLogin(String login);
}
