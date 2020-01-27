package com.example.DailyReport.domain;

public class AdminsCompanies {

    /*管理者ID */
    private Integer admins_id;
    /*企業ID */
    private Integer companies_id;

    public AdminsCompanies(Integer admins_id, Integer companies_id) {
        this.admins_id = admins_id;
        this.companies_id = companies_id;
    }

    public AdminsCompanies() {
    }

    @Override
    public String toString() {
        return "AdminsCompanies{" +
                "admins_id=" + admins_id +
                ", companies_id=" + companies_id +
                '}';
    }

    public Integer getAdmins_id() {
        return admins_id;
    }

    public void setAdmins_id(Integer admins_id) {
        this.admins_id = admins_id;
    }

    public Integer getCompanies_id() {
        return companies_id;
    }

    public void setCompanies_id(Integer companies_id) {
        this.companies_id = companies_id;
    }
}
