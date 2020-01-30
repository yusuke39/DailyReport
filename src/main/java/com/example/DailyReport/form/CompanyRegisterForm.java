package com.example.DailyReport.form;

public class CompanyRegisterForm {

    /* 企業ID*/
    private Integer id;
    /* 企業名*/
    private String companyName;
    /* 企業名（カナ）*/
    private String companyKana;
    /* 備考*/
    private String remarks;

    public CompanyRegisterForm(Integer id, String companyName, String companyKana, String remarks) {
        this.id = id;
        this.companyName = companyName;
        this.companyKana = companyKana;
        this.remarks = remarks;
    }

    public CompanyRegisterForm() {
    }

    @Override
    public String toString() {
        return "CompanyRegisterForm{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyKana='" + companyKana + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyKana() {
        return companyKana;
    }

    public void setCompanyKana(String companyKana) {
        this.companyKana = companyKana;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
