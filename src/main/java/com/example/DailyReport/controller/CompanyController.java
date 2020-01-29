package com.example.DailyReport.controller;

import com.example.DailyReport.domain.Companies;
import com.example.DailyReport.form.CompanyRegisterForm;
import com.example.DailyReport.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /**
     * 企業と関連する企業担当者を全件表示する.
     * @return
     */
    @RequestMapping("/company/companyList")
    public String companyList(Model model) {

        List<Companies> companiesAndCompanyMemberList = companyService.findCompanyAndCompanyMember();


        model.addAttribute("companiesAndCompanyMemberList" ,companiesAndCompanyMemberList);

        return "admin/company_list";
    }


    /**
     * 企業新規登録画面を表示
     * @return
     */
    @RequestMapping("/company/companyDetailRegister")
    public String companyDetailRegister(){
        return"admin/company_detail";
    }



    @RequestMapping("/company/companyRegister")
    public String companyRegister(CompanyRegisterForm companyRegisterForm){

        Companies companies = new Companies();
        companies.setName(companyRegisterForm.getCompanyName());
        companies.setKana(companyRegisterForm.getCompanyKana());
        companies.setRemarks(companyRegisterForm.getRemarks());

        companyService.insertCompany(companies);

        return "redirect:/company/companyList";
    }


}
