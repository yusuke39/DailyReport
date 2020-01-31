package com.example.DailyReport.domain;

public class InstructorOne {

    /* 講師ID*/
    private Integer idOne;
    /* 講師名*/
    private String nameOne;
    /* 講師名（かな）*/
    private String kanaOne;
    /* 講師メールアドレス*/
    private String emailOne;
    /* 講師パスワード*/
    private String passwordOne;
    /* 所属*/
    private String affiliationOne;
    /* 備考*/
    private String remarksOne;

    public InstructorOne(Integer idOne, String nameOne, String kanaOne, String emailOne, String passwordOne, String affiliationOne, String remarksOne) {
        this.idOne = idOne;
        this.nameOne = nameOne;
        this.kanaOne = kanaOne;
        this.emailOne = emailOne;
        this.passwordOne = passwordOne;
        this.affiliationOne = affiliationOne;
        this.remarksOne = remarksOne;
    }

    public InstructorOne() {
    }

    @Override
    public String toString() {
        return "InstructorOne{" +
                "idOne=" + idOne +
                ", nameOne='" + nameOne + '\'' +
                ", kanaOne='" + kanaOne + '\'' +
                ", emailOne='" + emailOne + '\'' +
                ", passwordOne='" + passwordOne + '\'' +
                ", affiliationOne='" + affiliationOne + '\'' +
                ", remarksOne='" + remarksOne + '\'' +
                '}';
    }

    public Integer getIdOne() {
        return idOne;
    }

    public void setIdOne(Integer idOne) {
        this.idOne = idOne;
    }

    public String getNameOne() {
        return nameOne;
    }

    public void setNameOne(String nameOne) {
        this.nameOne = nameOne;
    }

    public String getKanaOne() {
        return kanaOne;
    }

    public void setKanaOne(String kanaOne) {
        this.kanaOne = kanaOne;
    }

    public String getEmailOne() {
        return emailOne;
    }

    public void setEmailOne(String emailOne) {
        this.emailOne = emailOne;
    }

    public String getPasswordOne() {
        return passwordOne;
    }

    public void setPasswordOne(String passwordOne) {
        this.passwordOne = passwordOne;
    }

    public String getAffiliationOne() {
        return affiliationOne;
    }

    public void setAffiliationOne(String affiliationOne) {
        this.affiliationOne = affiliationOne;
    }

    public String getRemarksOne() {
        return remarksOne;
    }

    public void setRemarksOne(String remarksOne) {
        this.remarksOne = remarksOne;
    }
}
