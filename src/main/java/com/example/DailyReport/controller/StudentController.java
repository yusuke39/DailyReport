package com.example.DailyReport.controller;

import com.example.DailyReport.domain.DailyReport;
import com.example.DailyReport.domain.Student;
import com.example.DailyReport.form.DailyRegisterForm;
import com.example.DailyReport.form.StudentLoginForm;
import com.example.DailyReport.security.Student.LoginStudent;
import com.example.DailyReport.service.StudentService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Arrays;
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


    @RequestMapping("/loginPage")
    public String loginPage(Model model, @RequestParam(required = false) String error){

        if(error != null){
            model.addAttribute("aaaaaaaaaaaa");
        }

        return "student/student_login";
    }

    /**
     * 受講生に紐づいている研修を全て表示する.
     * @param model
     * @return
     */
    @RequestMapping("/studentTrainingList")
    public String studentTrainingList(Model model, @AuthenticationPrincipal LoginStudent loginStudent){


        List<Student> studentList = studentService.findAllTrainingRelationStudentByStudentId(loginStudent.getStudent().getId());

        model.addAttribute("student",studentList.get(0));

        return"student/student_training_list";
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
     *日報登録する.
     * @param dailyregisterForm
     * @return
     */
    @RequestMapping("/studentDairyReportInsert")
    public String studentDairyReportInsert(DailyRegisterForm dailyregisterForm) throws ParseException {

        studentService.insertDairyReport(dailyregisterForm);

        return "redirect:/student/studentTrainingList";
    }


    /**
     * 生徒の日報閲覧画面を表示する.
     * @return
     */
    @RequestMapping("/studentDairyReportBrowsing")
    public String studentDairyReport(Model model){

        int trainingId = Integer.parseInt(httpServletRequest.getParameter("trainingId"));
        model.addAttribute("trainingId", trainingId);

        int studentId = Integer.parseInt(httpServletRequest.getParameter("studentId"));
        model.addAttribute("studentId", studentId);

        List<String> daysList =  studentService.BrowsingDairyReport(trainingId);

        model.addAttribute("daysList",daysList);

        return "student/student_view_daily_report";
    }

}
