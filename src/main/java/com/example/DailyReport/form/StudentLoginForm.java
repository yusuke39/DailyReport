package com.example.DailyReport.form;

public class StudentLoginForm {

    private String studentEmail;
    private String studentPassword;


    public StudentLoginForm(String studentEmail, String studentPassword) {
        this.studentEmail = studentEmail;
        this.studentPassword = studentPassword;
    }


    public StudentLoginForm() {
    }

    @Override
    public String toString() {
        return "StudentLoginForm{" +
                "studentEmail='" + studentEmail + '\'' +
                ", studentPassword='" + studentPassword + '\'' +
                '}';
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }
}

