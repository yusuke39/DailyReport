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
     * 講師を１件検索する.
     * @param instructorId
     * @return
     */
    Instructor findInstructorById(int instructorId);


    /**
     * 講師をinsertする
     * @param instructor
     */
    void insertInstructor(Instructor instructor);


    /**
     * 講師をupdateする
     * @param instructor
     */
    void updateInstructor(Instructor instructor);
}
