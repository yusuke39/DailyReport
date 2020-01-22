package com.example.DailyReport.form;

public class LoginAdmin {

    /*メールアドレス*/
    private String email;
    /*パスワード*/
    private String password;

    public LoginAdmin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginAdmin() {
    }

    @Override
    public String toString() {
        return "LoginAdmin{" +
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
