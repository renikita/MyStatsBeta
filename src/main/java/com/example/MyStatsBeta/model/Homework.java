package com.example.MyStatsBeta.model;

import com.example.MyStatsBeta.model.enums.HomeworkStatus;
import com.example.MyStatsBeta.model.Student;
import com.example.MyStatsBeta.model.Teacher;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "homework")
public class Homework {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nameHomework;
    private String task;
    @Column(name = "homework_description", columnDefinition = "TEXT")
    private String description;
    private LocalDateTime uploadTime;
    private LocalDateTime deadline;

    @Enumerated(EnumType.STRING)
    private HomeworkStatus homeworkStatus;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    
    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "homework_students",
            joinColumns = @JoinColumn(name = "homework_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;
}