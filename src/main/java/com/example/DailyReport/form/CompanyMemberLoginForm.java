package com.example.DailyReport.form;

public class CompanyMemberLoginForm {

    private String email;
    private String password;

    public CompanyMemberLoginForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public CompanyMemberLoginForm() {
    }

    @Override
    public String toString() {
        return "CompanyMemberLoginForm{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
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
}
