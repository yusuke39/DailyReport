package com.example.DailyReport.domain;

public class AdminsAndCompanies {

    /*管理者ID*/
    private Integer a_id;
    /*管理者氏名*/
    private String a_name;
    /*A管理者名（かな）*/
    private String a_kana;
    /*管理者メールアドレス*/
    private String a_email;
    /*管理者パスワード*/
    private String a_password;
    /*管理者がどの企業の閲覧許可があるか*/
    private boolean a_canShowAllCompanies;
    /*管理者ID（中間テーブル）*/
    private Integer ac_adminsId;
    /*企業ID（中間テーブル）*/
    private Integer ac_companiesId;
    /*企業ID*/
    private Integer c_id;
    /*企業名*/
    private String c_name;
    /*企業名（かな）*/
    private String c_kana;
    /*備考（企業）*/
    private String c_remarks;

    public AdminsAndCompanies(Integer a_id, String a_name, String a_kana, String a_email, String a_password, boolean a_canShowAllCompanies,
                              Integer ac_adminsId, Integer ac_companiesId, Integer c_id, String c_name, String c_kana, String c_remarks) {
        this.a_id = a_id;
        this.a_name = a_name;
        this.a_kana = a_kana;
        this.a_email = a_email;
        this.a_password = a_password;
        this.a_canShowAllCompanies = a_canShowAllCompanies;
        this.ac_adminsId = ac_adminsId;
        this.ac_companiesId = ac_companiesId;
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_kana = c_kana;
        this.c_remarks = c_remarks;
    }

    public AdminsAndCompanies() {
    }

    @Override
    public String toString() {
        return "AdminsAndCompanies{" +
                "a_id=" + a_id +
                ", a_name='" + a_name + '\'' +
                ", a_kana='" + a_kana + '\'' +
                ", a_email='" + a_email + '\'' +
                ", a_password='" + a_password + '\'' +
                ", a_canShowAllCompanies=" + a_canShowAllCompanies +
                ", ac_adminsId=" + ac_adminsId +
                ", ac_companiesId=" + ac_companiesId +
                ", c_id=" + c_id +
                ", c_name='" + c_name + '\'' +
                ", c_kana='" + c_kana + '\'' +
                ", c_remarks='" + c_remarks + '\'' +
                '}';
    }


    public Integer getA_id() {
        return a_id;
    }

    public void setA_id(Integer a_id) {
        this.a_id = a_id;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public String getA_kana() {
        return a_kana;
    }

    public void setA_kana(String a_kana) {
        this.a_kana = a_kana;
    }

    public String getA_email() {
        return a_email;
    }

    public void setA_email(String a_email) {
        this.a_email = a_email;
    }

    public String getA_password() {
        return a_password;
    }

    public void setA_password(String a_password) {
        this.a_password = a_password;
    }

    public boolean isA_canShowAllCompanies() {
        return a_canShowAllCompanies;
    }

    public void setA_canShowAllCompanies(boolean a_canShowAllCompanies) {
        this.a_canShowAllCompanies = a_canShowAllCompanies;
    }

    public Integer getAc_adminsId() {
        return ac_adminsId;
    }

    public void setAc_adminsId(Integer ac_adminsId) {
        this.ac_adminsId = ac_adminsId;
    }

    public Integer getAc_companiesId() {
        return ac_companiesId;
    }

    public void setAc_companiesId(Integer ac_companiesId) {
        this.ac_companiesId = ac_companiesId;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_kana() {
        return c_kana;
    }

    public void setC_kana(String c_kana) {
        this.c_kana = c_kana;
    }

    public String getC_remarks() {
        return c_remarks;
    }

    public void setC_remarks(String c_remarks) {
        this.c_remarks = c_remarks;
    }
}
