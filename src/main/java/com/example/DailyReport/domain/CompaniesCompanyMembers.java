package com.example.DailyReport.domain;

public class CompaniesCompanyMembers {

    /* 企業ID*/
    private Integer companies_id;
    /* 企業担当者ID*/
    private Integer company_members_id;

    public CompaniesCompanyMembers(Integer companies_id, Integer company_members_id) {
        this.companies_id = companies_id;
        this.company_members_id = company_members_id;
    }

    public CompaniesCompanyMembers() {
    }

    @Override
    public String toString() {
        return "CompaniesCompanyMembers{" +
                "companies_id=" + companies_id +
                ", company_members_id=" + company_members_id +
                '}';
    }

    public Integer getCompanies_id() {
        return companies_id;
    }

    public void setCompanies_id(Integer companies_id) {
        this.companies_id = companies_id;
    }

    public Integer getCompany_members_id() {
        return company_members_id;
    }

    public void setCompany_members_id(Integer company_members_id) {
        this.company_members_id = company_members_id;
    }
}
