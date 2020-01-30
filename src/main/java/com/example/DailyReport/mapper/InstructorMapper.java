package com.example.DailyReport.mapper;

import com.example.DailyReport.domain.Instructor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InstructorMapper {

    /**
     * 講師を全件検索する.
     * @return
     */
    List<Instructor> findAllInstructor();


    /**
     * 講師をinsertする
     * @param instructor
     */
    void insertInstructor(Instructor instructor);
}
