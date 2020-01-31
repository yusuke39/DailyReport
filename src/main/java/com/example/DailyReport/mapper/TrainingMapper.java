package com.example.DailyReport.mapper;

import com.example.DailyReport.domain.Instructor;
import com.example.DailyReport.domain.Training;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TrainingMapper {

    /**
     * 講師、受講生、研修を結合して全権取得する.
     * @return
     */
    List<Training> findAllTraining();


    /**
     * 講師を全権取得する.
     * @return
     */
    List<Instructor> findAllInstructor();


    /**
     * 研修をinsertする.
     */
    void insertTraining(Training training);



}
