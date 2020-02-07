package com.example.DailyReport.service;

import com.example.DailyReport.domain.Student;
import com.example.DailyReport.form.StudentLoginForm;
import com.example.DailyReport.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;


    /**
     * 受講生ログイン機能.
     * @param studentLoginForm
     * @return
     */
    public Student findStudentByEmailAndPassword(StudentLoginForm studentLoginForm){

        List<Student> studentList = studentMapper.findStudentByEmailAndPassword(studentLoginForm.getStudentEmail(), studentLoginForm.getStudentPassword());

        if(studentList.size() == 0){
            return null;
        }

        Student student = studentList.get(0);

        return student;
    }


    /**
     * 受講生IDを使って、関係している、研修と講師と企業を検索する.
     * @param studentId
     * @return
     */
    public List<Student> findAllTrainingRelationStudentByStudentId(int studentId){

        List<Student> studentList = studentMapper.findAllTrainingRelationStudentByStudentId(studentId);

        return studentList;
    }



}
