package com.example.DailyReport.form;


import java.util.List;

public class AdminEditForm {

    /*管理者ID*/
    private Integer adminId;
    /*氏名*/
    private String name;
    /*氏名（かな）*/
    private String kana;
    /*メールアドレス*/
    private String email;
    /*閲覧できる企業の範囲（true:すべて　false:選択した企業のみ)*/
    private boolean responsibleCompany;
    /*企業リスト*/
    private List<String> company;


    public AdminEditForm(Integer adminId, String name, String kana, String email, boolean responsibleCompany, List<String> company) {
        this.adminId = adminId;
        this.name = name;
        this.kana = kana;
        this.email = email;
        this.responsibleCompany = responsibleCompany;
        this.company = company;
    }

    public AdminEditForm() {
    }

    @Override
    public String toString() {
        return "AdminEditForm{" +
                "adminId=" + adminId +
                ", name='" + name + '\'' +
                ", kana='" + kana + '\'' +
                ", email='" + email + '\'' +
                ", responsibleCompany=" + responsibleCompany +
                ", company=" + company +
                '}';
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
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

    public boolean isResponsibleCompany() {
        return responsibleCompany;
    }

    public void setResponsibleCompany(boolean responsibleCompany) {
        this.responsibleCompany = responsibleCompany;
    }

    public List<String> getCompany() {
        return company;
    }

    public void setCompany(List<String> company) {
        this.company = company;
    }
}
