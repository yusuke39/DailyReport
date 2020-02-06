package com.example.DailyReport.controller;

import com.example.DailyReport.domain.Student;
import com.example.DailyReport.domain.StudentCsv;
import com.example.DailyReport.form.CsvFileForm;
import com.example.DailyReport.form.StudentLoginForm;
import com.example.DailyReport.service.StudentFile;
import com.example.DailyReport.service.StudentService;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentFile studentFile;

    @Autowired
    private HttpSession session;


    /**
     * 受講生用のログインフォーム表示.
     * @return
     */
    @RequestMapping("/loginForm")
    public String studentLoginFrom(){
        return"student/student_login";
    }

    /**
     * 受講生用のログインフォーム
     * @return
     */
    @RequestMapping("/login")
    public String login(StudentLoginForm studentLoginForm, Model model){


        List<Student> studentList = studentService.findStudentByEmailAndPassword(studentLoginForm);

        if(studentList == null){
            model.addAttribute("nullStudent", "メールアドレスかパスワードが一致しません");
        }

        return"student/student_training_list";
    }

    /**
     * 受講者情報インポート画面表示.
     * @return
     */
    @RequestMapping("/registerStudent")
    public String registerStudent(){

        return "admin/admin_training_import_students";
    }

}