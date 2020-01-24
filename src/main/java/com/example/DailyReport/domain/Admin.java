package com.example.DailyReport.domain;

import java.util.List;


public class Admin {

    private Integer id;
    /*氏名*/
    private String name;
    /*かな*/
    private String kana;
    /*メールアドレス*/
    private String email;
    /*パスワード*/
    private String password;
    /*全ての企業を閲覧できる権限があるか（true:見れる、false:見れない）*/
    private boolean canShowAllCompany;
    /*企業リスト*/
    private List<Companies> companyList;


    public Admin(Integer id, String name, String kana, String email, String password, boolean canShowAllCompany, List<Companies> companyList) {
        this.id = id;
        this.name = name;
        this.kana = kana;
        this.email = email;
        this.password = password;
        this.canShowAllCompany = canShowAllCompany;
        this.companyList = companyList;
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kana='" + kana + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", canShowAllCompany=" + canShowAllCompany +
                ", companyList=" + companyList +
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

    public boolean isCanShowAllCompany() {
        return canShowAllCompany;
    }

    public void setCanShowAllCompany(boolean canShowAllCompany) {
        this.canShowAllCompany = canShowAllCompany;
    }

    public List<Companies> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Companies> companyList) {
        this.companyList = companyList;
    }
}
