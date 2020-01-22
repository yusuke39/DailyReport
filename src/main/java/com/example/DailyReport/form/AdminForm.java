package com.example.DailyReport.form;

public class AdminForm {

    /*氏名*/
    private String name;
    /*かな*/
    private String kana;
    /*メールアドレス*/
    private String email;
    /*パスワード*/
    private String password;

    public AdminForm(String name, String kana, String email, String password) {
        this.name = name;
        this.kana = kana;
        this.email = email;
        this.password = password;
    }

    public AdminForm() {
    }

    @Override
    public String toString() {
        return "AdminForm{" +
                "name='" + name + '\'' +
                ", kana='" + kana + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKana() {
        return kana;
    }

    public void setKana(String kana) {
        this.kana = kana;
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
