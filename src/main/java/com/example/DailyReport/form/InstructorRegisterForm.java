package com.example.DailyReport.form;

public class InstructorRegisterForm {

    /* 講師ID*/
    private Integer instructorId;
    /* 講師名*/
    private String instructorName;
    /* 講師名（かな）*/
    private String instructorKana;
    /* 講師メールアドレス*/
    private String instructorEmail;
    /* 講師パスワード*/
    private String instructorPassword;
    /* 所属*/
    private String affiliation;
    /* 備考*/
    private String remarks;


    public InstructorRegisterForm(Integer instructorId, String instructorName, String instructorKana, String instructorEmail,
                                  String instructorPassword, String affiliation, String remarks) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.instructorKana = instructorKana;
        this.instructorEmail = instructorEmail;
        this.instructorPassword = instructorPassword;
        this.affiliation = affiliation;
        this.remarks = remarks;
    }

    public InstructorRegisterForm() {
    }

    @Override
    public String toString() {
        return "InstructorRegisterForm{" +
                "instructorId=" + instructorId +
                ", instructorName='" + instructorName + '\'' +
                ", instructorKana='" + instructorKana + '\'' +
                ", instructorEmail='" + instructorEmail + '\'' +
                ", instructorPassword='" + instructorPassword + '\'' +
                ", affiliation='" + affiliation + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorKana() {
        return instructorKana;
    }

    public void setInstructorKana(String instructorKana) {
        this.instructorKana = instructorKana;
    }

    public String getInstructorEmail() {
        return instructorEmail;
    }

    public void setInstructorEmail(String instructorEmail) {
        this.instructorEmail = instructorEmail;
    }

    public String getInstructorPassword() {
        return instructorPassword;
    }

    public void setInstructorPassword(String instructorPassword) {
        this.instructorPassword = instructorPassword;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
