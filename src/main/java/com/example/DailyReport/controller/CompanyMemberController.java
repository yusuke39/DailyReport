package com.example.DailyReport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/companyMember")
public class CompanyMemberController {


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


    @RequestMapping("/companyTrainingList")
    public String companyTrainingList(){

        return "company/company_training_list";
    }



}
