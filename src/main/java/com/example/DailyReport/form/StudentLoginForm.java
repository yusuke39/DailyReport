package com.example.DailyReport.form;

public class StudentLoginForm {

    /* 受講生メールアドレス*/
    private String email;
    /* 受講生パスワード*/
    private String password;


    public StudentLoginForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public StudentLoginForm() {
    }

    @Override
    public String toString() {
        return "StudentLoginForm{" +
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

