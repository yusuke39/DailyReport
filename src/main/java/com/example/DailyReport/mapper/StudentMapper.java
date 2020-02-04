package com.example.DailyReport.mapper;

import com.example.DailyReport.domain.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    /**
     * 生徒テーブルから１件検索する.
     * @return
     */
    public List<Student> findStudentByEmailAndPassword(String email, String password);


}
