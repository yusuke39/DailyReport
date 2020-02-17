package com.example.DailyReport.form;

public class LoginAdminForm {

    /*メールアドレス*/
    private String email;
    /*パスワード*/
    private String password;

    public LoginAdminForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginAdminForm() {
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
