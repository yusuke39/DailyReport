package com.example.DailyReport.domain;


import com.opencsv.bean.CsvBindByName;

public class StudentCsv {

    @CsvBindByName(column = "受講者名", required = true)
    private String name;

    @CsvBindByName(column = "email", required = true)
    private String email;

    @CsvBindByName(column = "所属", required = true)
    private String affiliation;

    public StudentCsv(String name, String email, String affiliation) {
        this.name = name;
        this.email = email;
        this.affiliation = affiliation;
    }

    public StudentCsv() {
    }

    @Override
    public String toString() {
        return "StudentCsv{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", affiliation='" + affiliation + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }
}
