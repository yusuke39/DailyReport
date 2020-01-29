package com.example.DailyReport.form;

public class CompanyMemberRegisterForm {

    /*企業ID*/
    private Integer companyId;
    /* 企業担当名*/
    private String companyMemberName;
    /* 企業担当名（かな）*/
    private String companyMemberKana;
    /* 企業担当メールアドレス*/
    private String companyMemberEmail;
    /* 企業担当パスワード*/
    private String companyMemberPassword;


    public CompanyMemberRegisterForm(Integer companyId, String companyMemberName,
                                     String companyMemberKana, String companyMemberEmail, String companyMemberPassword) {
        this.companyId = companyId;
        this.companyMemberName = companyMemberName;
        this.companyMemberKana = companyMemberKana;
        this.companyMemberEmail = companyMemberEmail;
        this.companyMemberPassword = companyMemberPassword;
    }

    public CompanyMemberRegisterForm() {
    }

    @Override
    public String toString() {
        return "CompanyMemberRegisterForm{" +
                "companyId=" + companyId +
                ", companyMemberName='" + companyMemberName + '\'' +
                ", companyMemberKana='" + companyMemberKana + '\'' +
                ", companyMemberEmail='" + companyMemberEmail + '\'' +
                ", companyMemberPassword='" + companyMemberPassword + '\'' +
                '}';
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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
