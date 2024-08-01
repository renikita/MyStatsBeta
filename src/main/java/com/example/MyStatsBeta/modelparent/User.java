package com.example.MyStatsBeta.modelparent;

import jakarta.persistence.*;
import lombok.*;



@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public class User {


    public enum Role{
        TEACHER,
        STUDENT
    }

    public enum Status{
        ACTIVATED,
        BLOCKED
    }
    private String login;
    private String name;
    private String password;
    private Role role;
    private Status status;


}
