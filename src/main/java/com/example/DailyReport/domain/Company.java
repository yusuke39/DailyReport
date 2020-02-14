package com.example.DailyReport.domain;

import java.util.List;

public class Company {

    /*企業ID*/
    private Integer id;
    /*企業名*/
    private String name;
    /*企業名（かな）*/
    private String kana;
    /*備考*/
    private String remarks;
    /*企業担当者リスト*/
    private List<CompanyMember> companyMembersList;

    public Company(Integer id, String name, String kana, String remarks, List<CompanyMember> companyMembersList) {
        this.id = id;
        this.name = name;
        this.kana = kana;
        this.remarks = remarks;
        this.companyMembersList = companyMembersList;
    }

    public Company() {
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kana='" + kana + '\'' +
                ", remarks='" + remarks + '\'' +
                ", companyMembersList=" + companyMembersList +
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<CompanyMember> getCompanyMembersList() {
        return companyMembersList;
    }

    public void setCompanyMembersList(List<CompanyMember> companyMembersList) {
        this.companyMembersList = companyMembersList;
    }
}
