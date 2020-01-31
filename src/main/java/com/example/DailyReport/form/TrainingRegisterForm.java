package com.example.DailyReport.form;


import java.util.Date;

public class TrainingRegisterForm {

    private Integer trainingId;
    /* 研修名*/
    private String trainingName;
    /* 研修開始日*/
    private String startDate;
    /* 研修終了日*/
    private String endDate;
    /* 講師ID*/
    private Integer instructorId;
    /* サブ講師ID1*/
    private Integer subInstructorId1;
    /* サブ講師ID2*/
    private Integer subInstructorId2;
    /* サブ講師ID3*/
    private Integer subInstructorId3;


    public TrainingRegisterForm(Integer trainingId, String trainingName, String startDate, String endDate, Integer instructorId,
                                Integer subInstructorId1, Integer subInstructorId2, Integer subInstructorId3) {
        this.trainingId = trainingId;
        this.trainingName = trainingName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.instructorId = instructorId;
        this.subInstructorId1 = subInstructorId1;
        this.subInstructorId2 = subInstructorId2;
        this.subInstructorId3 = subInstructorId3;
    }

    public TrainingRegisterForm() {
    }

    @Override
    public String toString() {
        return "TrainingRegisterForm{" +
                "trainingId=" + trainingId +
                ", trainingName='" + trainingName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", instructorId=" + instructorId +
                ", subInstructorId1=" + subInstructorId1 +
                ", subInstructorId2=" + subInstructorId2 +
                ", subInstructorId3=" + subInstructorId3 +
                '}';
    }

    public Integer getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Integer trainingId) {
        this.trainingId = trainingId;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }

    public Integer getSubInstructorId1() {
        return subInstructorId1;
    }

    public void setSubInstructorId1(Integer subInstructorId1) {
        this.subInstructorId1 = subInstructorId1;
    }

    public Integer getSubInstructorId2() {
        return subInstructorId2;
    }

    public void setSubInstructorId2(Integer subInstructorId2) {
        this.subInstructorId2 = subInstructorId2;
    }

    public Integer getSubInstructorId3() {
        return subInstructorId3;
    }

    public void setSubInstructorId3(Integer subInstructorId3) {
        this.subInstructorId3 = subInstructorId3;
    }
}