package com.example.DailyReport.domain;

public class Instructor {

    /* 講師ID*/
    private Integer id;
    /* 講師名*/
    private String name;
    /* 講師名（かな）*/
    private String kana;
    /* 講師メールアドレス*/
    private String email;
    /* 講師パスワード*/
    private String password;
    /* 所属*/
    private String affiliation;
    /* 備考*/
    private String remarks;

    public Instructor(Integer id, String name, String kana, String email, String password, String affiliation, String remarks) {
        this.id = id;
        this.name = name;
        this.kana = kana;
        this.email = email;
        this.password = password;
        this.affiliation = affiliation;
        this.remarks = remarks;
    }

    public Instructor() {
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kana='" + kana + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", affiliation='" + affiliation + '\'' +
                ", remarks='" + remarks + '\'' +
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
