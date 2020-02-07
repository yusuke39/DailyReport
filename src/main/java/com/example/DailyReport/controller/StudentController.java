package com.example.DailyReport.controller;

import com.example.DailyReport.domain.Student;
import com.example.DailyReport.domain.Training;
import com.example.DailyReport.form.StudentLoginForm;
import com.example.DailyReport.service.StudentFile;
import com.example.DailyReport.service.StudentService;
import com.example.DailyReport.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TrainingService trainingService;


    /**
     * 受講生用のログインフォーム表示.
     * @return
     */
    @RequestMapping("/loginPage")
    public String studentLoginPage(){
        return"student/student_login";
    }

    @RequestMapping("/studentTrainingList")
    public String studentTrainingList(Model model){

        //TrainingServiceの研修を全権取得するメソッドを使って、研修と講師を全権取得する
        List<Training> trainingList = trainingService.findAllTrainings();

        model.addAttribute("trainingList",trainingList);

        return"student/student_training_list";
    }


    /**
     * ログイン機能（セキュリティ使うまでの仮）
     * @param studentLoginForm
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String studentLogin(StudentLoginForm studentLoginForm,Model model){

      Student student = studentService.findStudentByEmailAndPassword(studentLoginForm);

      if(student == null){
          model.addAttribute("不正なメールアドレスかパスワードです");
          return studentLoginPage();
      }

      return "student/student_training_list";

    }


    /**
     * 生徒の日報登録、閲覧画面を表示する.
     * @return
     */
    @RequestMapping("/studentDairyReport")
    public String studentDairyReport(){
        return "student/student_view_daily_report";
    }


}
