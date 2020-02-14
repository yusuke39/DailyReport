package com.example.DailyReport.security.Student;

import com.example.DailyReport.domain.Student;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class LoginStudent extends User {

    private final com.example.DailyReport.domain.Student Student;

    public LoginStudent(Student student, Collection<GrantedAuthority> authorityList) {
        super(student.getEmail(), student.getPassword(), authorityList);
        this.Student = student;
    }

    public com.example.DailyReport.domain.Student getStudent() {
        return Student;
    }
}
