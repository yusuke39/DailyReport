package com.example.DailyReport.domain;

public class CompanyMembers {

    /* 企業担当者ID*/
    private Integer id;
    /* 企業担当者名*/
    private String name;
    /* 企業担当者名（カナ）*/
    private String kana;
    /* 企業担当者メールアドレス*/
    private String email;
    /* パスワード*/
    private String password;

    public CompanyMembers(Integer id, String name, String kana, String email, String password) {
        this.id = id;
        this.name = name;
        this.kana = kana;
        this.email = email;
        this.password = password;
    }

    public CompanyMembers() {
    }

    @Override
    public String toString() {
        return "CompanyMembers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kana='" + kana + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
