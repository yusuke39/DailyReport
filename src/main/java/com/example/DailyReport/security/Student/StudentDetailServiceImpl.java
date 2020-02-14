package com.example.DailyReport.security.Student;

import com.example.DailyReport.domain.Student;
import com.example.DailyReport.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component("STUDENT")
public class StudentDetailServiceImpl implements UserDetailsService {


    @Autowired
    private StudentMapper studentMapper;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        if(studentMapper.findStudentByEmail(email).size() == 0){
            throw new UsernameNotFoundException("メールアドレスかパスワードが不正です");
        }

        List<Student> studentList = studentMapper.findStudentByEmail(email);
        Student student = studentList.get(0);

        Collection<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("STUDENT"));
        return new LoginStudent(student,authorityList);
    }
}
