package com.example.DailyReport.controller;

import com.example.DailyReport.domain.DailyReport;
import com.example.DailyReport.domain.Student;
import com.example.DailyReport.domain.Training;
import com.example.DailyReport.service.CompanyMemberService;
import com.example.DailyReport.service.ReuseMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/companyMember")
public class CompanyMemberController {

    @Autowired
    private CompanyMemberService companyMemberService;

    @Autowired
    private ReuseMethod reuseMethod;


    /**
     * 企業ログインページ.
     * @param model
     * @param error
     * @return
     */
    @RequestMapping("/loginPage")
    public String loginPage(Model model, @RequestParam(required = false) String error){

        if(error != null){
            model.addAttribute("loginError","パスワードかメールアドレスが不正です");
        }

        return "company/company_login";
    }


    /**
     * 企業担当に紐づいている受講生が受けている研修の一覧を表示する.
     * @return
     */
    @RequestMapping("/companyTrainingList")
    public String companyTrainingList(Model model){

        List<Training> trainingList = companyMemberService.findAllTrainingRelationCompanyByCompanyId(5);

        model.addAttribute("trainingList",trainingList);

        return "company/company_training_list";
    }


    /**
     * 日報閲覧の為に
     * @param model
     * @return
     */
    @RequestMapping("/adminViewDailyReport")
    public String adminViewDailyReport(Model model){

        //研修IDと企業IDで該当の研修、受講生、日報を持ってくる
        List<Training> trainingList = companyMemberService.findDairyReportAndStudentAndTraining(9, 5);

        //ReuseMethod.javaのメソッドを使って、日付を計算する
        List<String> daysList = reuseMethod.calculationDay(trainingList.get(0));
        model.addAttribute("daysList",daysList);

        //受講生の一覧をドロップダウンで表示させる
        List<Student> studentList = trainingList.get(0).getStudentList();
        model.addAttribute("studentList",studentList);

        model.addAttribute("dailyReportList", trainingList);

        return "admin/admin_view_daily_report";
    }



}
