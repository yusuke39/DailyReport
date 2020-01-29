package com.example.DailyReport.form;

public class CompanyMemberForm {

    /* 企業担当名*/
    private String companyMemberName;
    /* 企業担当名（かな）*/
    private String companyMemberKana;
    /* 企業担当メールアドレス*/
    private String companyMemberEmail;
    /* 企業担当パスワード*/
    private String companyMemberPassword;

    public CompanyMemberForm(String companyMemberName, String companyMemberKana, String companyMemberEmail, String companyMemberPassword) {
        this.companyMemberName = companyMemberName;
        this.companyMemberKana = companyMemberKana;
        this.companyMemberEmail = companyMemberEmail;
        this.companyMemberPassword = companyMemberPassword;
    }

    public CompanyMemberForm(String companyMemberName) {
        this.companyMemberName = companyMemberName;
    }

    @Override
    public String toString() {
        return "CompanyMemberForm{" +
                "companyMemberName='" + companyMemberName + '\'' +
                ", companyMemberKana='" + companyMemberKana + '\'' +
                ", companyMemberEmail='" + companyMemberEmail + '\'' +
                ", companyMemberPassword='" + companyMemberPassword + '\'' +
                '}';
    }

    public String getCompanyMemberName() {
        return companyMemberName;
    }

    public void setCompanyMemberName(String companyMemberName) {
        this.companyMemberName = companyMemberName;
    }

    public String getCompanyMemberKana() {
        return companyMemberKana;
    }

    public void setCompanyMemberKana(String companyMemberKana) {
        this.companyMemberKana = companyMemberKana;
    }

    public String getCompanyMemberEmail() {
        return companyMemberEmail;
    }

    public void setCompanyMemberEmail(String companyMemberEmail) {
        this.companyMemberEmail = companyMemberEmail;
    }

    public String getCompanyMemberPassword() {
        return companyMemberPassword;
    }

    public void setCompanyMemberPassword(String companyMemberPassword) {
        this.companyMemberPassword = companyMemberPassword;
    }
}
