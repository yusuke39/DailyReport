package com.example.DailyReport.domain;

import java.util.List;

public class Companies {

    /*企業ID*/
    private Integer id;
    /*企業名*/
    private String name;
    /*企業名（かな）*/
    private String kana;
    /*備考*/
    private String remarks;
    /*企業担当者リスト*/
    private List<CompanyMembers> companyMembersList;

    public Companies(Integer id, String name, String kana, String remarks, List<CompanyMembers> companyMembersList) {
        this.id = id;
        this.name = name;
        this.kana = kana;
        this.remarks = remarks;
        this.companyMembersList = companyMembersList;
    }

    public Companies() {
    }

    @Override
    public String toString() {
        return "Companies{" +
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

    public List<CompanyMembers> getCompanyMembersList() {
        return companyMembersList;
    }

    public void setCompanyMembersList(List<CompanyMembers> companyMembersList) {
        this.companyMembersList = companyMembersList;
    }
}
