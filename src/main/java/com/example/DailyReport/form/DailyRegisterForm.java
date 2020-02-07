package com.example.DailyReport.form;

import java.time.LocalDate;

public class DailyRegisterForm {

    /* 日付*/
    private String date;
    /* 受講生ID*/
    private Integer studentId;
    /* 研修ID*/
    private Integer trainingId;
    /* 内容*/
    private String content;
    /* 理解度*/
    private Integer intelligibility;
    /* 理解度詳細*/
    private String detailIntelligibility;
    /* 講師について*/
    private Integer aboutInstructor;
    /* 質問*/
    private String question;


    public DailyRegisterForm(String date, Integer studentId, Integer trainingId, String content, Integer intelligibility,
                             String detailIntelligibility, Integer aboutInstructor, String question) {
        this.date = date;
        this.studentId = studentId;
        this.trainingId = trainingId;
        this.content = content;
        this.intelligibility = intelligibility;
        this.detailIntelligibility = detailIntelligibility;
        this.aboutInstructor = aboutInstructor;
        this.question = question;
    }

    public DailyRegisterForm() {
    }

    @Override
    public String toString() {
        return "DailyRegisterForm{" +
                "date='" + date + '\'' +
                ", studentId=" + studentId +
                ", trainingId=" + trainingId +
                ", content='" + content + '\'' +
                ", intelligibility=" + intelligibility +
                ", detailIntelligibility='" + detailIntelligibility + '\'' +
                ", aboutInstructor=" + aboutInstructor +
                ", question='" + question + '\'' +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Integer trainingId) {
        this.trainingId = trainingId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIntelligibility() {
        return intelligibility;
    }

    public void setIntelligibility(Integer intelligibility) {
        this.intelligibility = intelligibility;
    }

    public String getDetailIntelligibility() {
        return detailIntelligibility;
    }

    public void setDetailIntelligibility(String detailIntelligibility) {
        this.detailIntelligibility = detailIntelligibility;
    }

    public Integer getAboutInstructor() {
        return aboutInstructor;
    }

    public void setAboutInstructor(Integer aboutInstructor) {
        this.aboutInstructor = aboutInstructor;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}

