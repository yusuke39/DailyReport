package com.example.DailyReport.domain;


import java.util.List;

public class Student {

    /* 受講生ID*/
    private Integer id;
    /* 受講生名*/
    private String name;
    /* 受講生名（かな）*/
    private String kana;
    /* 受講生メールアドレス*/
    private String email;
    /* 受講生パスワード*/
    private String password;
    /* 会社ID*/
    private Integer companyId;
    /* 研修リスト*/
    private List<Training> trainingList;
    /* 企業*/
    private Company company;
    /* 講師*/
    private Instructor instructor;


    public Student(Integer id, String name, String kana, String email, String password, Integer companyId,
                   List<Training> trainingList, Company company, Instructor instructor) {
        this.id = id;
        this.name = name;
        this.kana = kana;
        this.email = email;
        this.password = password;
        this.companyId = companyId;
        this.trainingList = trainingList;
        this.company = company;
        this.instructor = instructor;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kana='" + kana + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", companyId=" + companyId +
                ", trainingList=" + trainingList +
                ", company=" + company +
                ", instructor=" + instructor +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKana() {
        return kana;
    }

    public void setKana(String kana) {
        this.kana = kana;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public List<Training> getTrainingList() {
        return trainingList;
    }

    public void setTrainingList(List<Training> trainingList) {
        this.trainingList = trainingList;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
