package com.example.DailyReport.service;

import com.example.DailyReport.domain.Instructor;
import com.example.DailyReport.domain.Training;
import com.example.DailyReport.form.TrainingRegisterForm;
import com.example.DailyReport.mapper.TrainingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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


    /**
     * 講師を全権取得する.
     * @return
     */
    public List<Instructor> findAllInstructor(){

        List<Instructor> instructorList = trainingMapper.findAllInstructor();

        return instructorList;
    }


    /**
     * 研修を1件検索する.
     * @param trainingId
     * @return
     */
    public Training findTrainingById(int trainingId){

        Training training = trainingMapper.findTrainingById(trainingId);

        return training;
    }

    /**
     * 研修を追加する.
     * @param trainingRegisterForm
     */
    public void insertTraining(TrainingRegisterForm trainingRegisterForm){

       LocalDate startDate =  LocalDate.parse(trainingRegisterForm.getStartDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
       LocalDate endDate = LocalDate.parse(trainingRegisterForm.getEndDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Training training = new Training();
        training.setStartDate(startDate);
        training.setEndDate(endDate);
        training.setName(trainingRegisterForm.getTrainingName());
        training.setInstructorId(trainingRegisterForm.getInstructorId());
        training.setSubInstructorId1(trainingRegisterForm.getSubInstructorId1());
        training.setSubInstructorId2(trainingRegisterForm.getSubInstructorId2());
        training.setSubInstructorId3(trainingRegisterForm.getSubInstructorId3());
        trainingMapper.insertTraining(training);
    }

    /**
     * 研修の編集.
     * @param trainingRegisterForm
     */
    public void updateTraining(TrainingRegisterForm trainingRegisterForm){

        LocalDate startDate =  LocalDate.parse(trainingRegisterForm.getStartDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate endDate = LocalDate.parse(trainingRegisterForm.getEndDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Training training = new Training();
        training.setId(trainingRegisterForm.getTrainingId());
        training.setStartDate(startDate);
        training.setEndDate(endDate);
        training.setName(trainingRegisterForm.getTrainingName());
        training.setInstructorId(trainingRegisterForm.getInstructorId());
        training.setSubInstructorId1(trainingRegisterForm.getSubInstructorId1());
        training.setSubInstructorId2(trainingRegisterForm.getSubInstructorId2());
        training.setSubInstructorId3(trainingRegisterForm.getSubInstructorId3());
        trainingMapper.updateTraining(training);

    }

}
