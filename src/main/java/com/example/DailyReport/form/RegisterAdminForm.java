package com.example.DailyReport.form;

import com.example.DailyReport.domain.Companies;

import java.util.List;

public class RegisterAdminForm {

    /*管理者名 */
    private String name;
    /*かな*/
    private String kana;
    /*管理者メールアドレス*/
    private String email;
    /*パスワード*/
    private String password;
    /*確認用パスワード*/
    private String confirmPassword;
    /*閲覧できる企業の範囲（true:すべて　false:選択した企業のみ)*/
    private boolean responsibleCompany;
    /*選択した企業（responsibleCompanyがfalseの場合/数値で受け取る)*/
    private List<String> company;


    public RegisterAdminForm(String name, String kana, String email, String password, String confirmPassword, boolean responsibleCompany, List<String> company) {
        this.name = name;
        this.kana = kana;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.responsibleCompany = responsibleCompany;
        this.company = company;
    }

    public RegisterAdminForm() {
    }

    @Override
    public String toString() {
        return "RegisterAdminForm{" +
                "name='" + name + '\'' +
                ", kana='" + kana + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", responsibleCompany=" + responsibleCompany +
                ", company=" + company +
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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
