package com.example.DailyReport.controller;

import com.example.DailyReport.domain.Student;
import com.example.DailyReport.domain.Training;
import com.example.DailyReport.service.CompanyMemberService;
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



}
