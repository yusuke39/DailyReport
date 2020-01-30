package com.example.DailyReport.service;

import com.example.DailyReport.domain.Instructor;
import com.example.DailyReport.form.InstructorRegisterForm;
import com.example.DailyReport.mapper.InstructorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    @Autowired
    private InstructorMapper instructorMapper;

    /**
     * 講師を全権検索する.
     * @return
     */
    public List<Instructor> findAllInstroctur(){

        List<Instructor> instructorList = instructorMapper.findAllInstructor();

        return instructorList;
    }


    /**
     * 講師を新規登録する.
     * @param instructorRegisterForm
     */
    public void insertInstructor(InstructorRegisterForm instructorRegisterForm){

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode(instructorRegisterForm.getInstructorPassword());

        Instructor instructor = new Instructor();
        instructor.setName(instructorRegisterForm.getInstructorName());
        instructor.setKana(instructorRegisterForm.getInstructorKana());
        instructor.setEmail(instructorRegisterForm.getInstructorEmail());
        instructor.setPassword(password);
        instructor.setAffiliation(instructorRegisterForm.getAffiliation());
        instructor.setRemarks(instructorRegisterForm.getRemarks());
        instructorMapper.insertInstructor(instructor);


    }
}
