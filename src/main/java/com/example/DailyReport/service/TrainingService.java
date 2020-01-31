package com.example.DailyReport.service;

import com.example.DailyReport.domain.Training;
import com.example.DailyReport.mapper.TrainingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {

    @Autowired
    private TrainingMapper trainingMapper;

    /**
     * 研修、講師を取得する.
     * @return
     */
    public List<Training> findAllTrainings(){

        List<Training> trainingList = trainingMapper.findAllTraining();

        return trainingList;
    }
}
