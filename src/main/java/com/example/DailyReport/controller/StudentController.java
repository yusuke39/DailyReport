package com.example.DailyReport.controller;

import com.example.DailyReport.domain.Student;
import com.example.DailyReport.form.DailyRegisterForm;
import com.example.DailyReport.form.StudentLoginForm;
import com.example.DailyReport.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletRequest httpServletRequest;


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

        session.setAttribute("studentId", student.getId());
        session.getAttribute("studentId");

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


    /**
     * 日報登録ページ表示.
     * @param model
     * @return
     */
    @RequestMapping("/studentDairyReportRegister")
    public String studentDairyReportRegister(Model model){

        //受講生のIDをクエリから取得
        String id = httpServletRequest.getParameter("studentId");
        int studentId = Integer.parseInt(id);
        model.addAttribute("studentId",studentId);
        //研修のIDをクエリから取得
        String t_id = httpServletRequest.getParameter("trainingId");
        int trainingId = Integer.parseInt(t_id);
        model.addAttribute("trainingId",trainingId);
        //本日の日付を取得
        LocalDate localDate = LocalDate.now();
        model.addAttribute("localDate",localDate);

        return "student/student_register_daily_report";
    }


    /**
     *
     * @param dailyregisterForm
     * @return
     */
    @RequestMapping("/studentDairyReportInsert")
    public String studentDairyReportInsert(DailyRegisterForm dailyregisterForm) throws ParseException {

        studentService.insertDairyReport(dailyregisterForm);

        return "redirect:/student/studentTrainingList";
    }


    /**
     * 生徒の日報登録、閲覧画面を表示する.
     * @return
     */
    @RequestMapping("/studentDairyReportBrowsing")
    public String studentDairyReport(Model model){

        int trainingId = Integer.parseInt(httpServletRequest.getParameter("trainingId"));

        List<String> daysList =  studentService.BrowsingDairyReport(trainingId);

        model.addAttribute("daysList",daysList);

        return "student/student_view_daily_report";
    }


}
