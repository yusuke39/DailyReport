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
    private HttpSession session;


    /**
     * 受講生用のログインフォーム表示.
     * @return
     */
    @RequestMapping("/loginPage")
    public String studentLoginPage(){
        return"student/student_login";
    }


    /**
     * 受講生に紐づいている研修を全て表示する.
     * @param model
     * @return
     */
    @RequestMapping("/studentTrainingList")
    public String studentTrainingList(Model model){

        Student student = (Student)session.getAttribute("student");

        model.addAttribute("studentId", student.getId());

        List<Student> studentList = studentService.findAllTrainingRelationStudentByStudentId(13);

        model.addAttribute("student",studentList.get(0));

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

      session.setAttribute("student", student);

      if(student == null){
          model.addAttribute("不正なメールアドレスかパスワードです");
          return studentLoginPage();
      }

      return "redirect:studentTrainingList";

    }


    @RequestMapping("/studentDairyReportRegister")
    public String studentDairyReportRegister(){

        return "student/student_register_daily_report";
    }


    /**
     * 生徒の日報登録、閲覧画面を表示する.
     * @return
     */
    @RequestMapping("/studentDairyReportBrowsing")
    public String studentDairyReport(){

        return "student/student_view_daily_report";
    }


}
