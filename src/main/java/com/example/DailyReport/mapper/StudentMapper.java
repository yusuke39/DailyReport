package com.example.DailyReport.mapper;

import com.example.DailyReport.domain.DailyReport;
import com.example.DailyReport.domain.Student;
import com.example.DailyReport.form.DailyRegisterForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    /**
     * 生徒テーブルから１件検索する.
     * @return
     */
    public List<Student> findStudentByEmailAndPassword(String email, String password);


    /**
     * 受講生IDを使って、研修と講師と企業を検索する.
     * @param studentId
     * @return
     */
    public List<Student> findAllTrainingRelationStudentByStudentId(int studentId);


    /**
     * 日報を登録する
     * @param dailyReport
     */
    public void insertDairyReport(DailyReport dailyReport);


}
