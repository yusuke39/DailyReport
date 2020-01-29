package com.example.DailyReport.form;

public class CompanyRegisterForm {

    /* 企業名*/
    private String companyName;
    /* 企業名（カナ）*/
    private String companyKana;
    /* 備考*/
    private String remarks;

    public CompanyRegisterForm(String companyName, String companyKana, String remarks) {
        this.companyName = companyName;
        this.companyKana = companyKana;
        this.remarks = remarks;
    }

    public CompanyRegisterForm() {
    }

    @Override
    public String toString() {
        return "CompanyRegisterForm{" +
                "companyName='" + companyName + '\'' +
                ", companyKana='" + companyKana + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
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
