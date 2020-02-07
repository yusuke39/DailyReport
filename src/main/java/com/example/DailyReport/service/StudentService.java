package com.example.DailyReport.service;

import com.example.DailyReport.domain.DailyReport;
import com.example.DailyReport.domain.Student;
import com.example.DailyReport.form.DailyRegisterForm;
import com.example.DailyReport.form.StudentLoginForm;
import com.example.DailyReport.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
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


    /**
     * 日報登録をする.
     * @param dailyRegisterForm
     */
    public void insertDairyReport(DailyRegisterForm dailyRegisterForm){

        LocalDate localDate = LocalDate.now();

        DailyReport dailyReport = new DailyReport();
        dailyReport.setDate(localDate);
        dailyReport.setTrainingId(dailyRegisterForm.getTrainingId());
        dailyReport.setStudentId(dailyRegisterForm.getStudentId());
        dailyReport.setContent(dailyRegisterForm.getContent());
        dailyReport.setIntelligibility(dailyRegisterForm.getIntelligibility());
        dailyReport.setDetailIntelligibility(dailyRegisterForm.getDetailIntelligibility());
        dailyReport.setAboutInstructor(dailyRegisterForm.getAboutInstructor());
        dailyReport.setQuestion(dailyRegisterForm.getQuestion());


        studentMapper.insertDairyReport(dailyReport);
    }



}
