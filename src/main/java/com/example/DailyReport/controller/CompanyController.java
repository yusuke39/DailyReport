package com.example.DailyReport.controller;

import com.example.DailyReport.domain.Company;
import com.example.DailyReport.form.CompanyRegisterForm;
import com.example.DailyReport.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private HttpServletRequest httpServletRequest;


    /**
     * 企業と関連する企業担当者を全件表示する.
     * @return
     */
    @RequestMapping("/company/companyList")
    public String companyList(Model model) {

        List<Company> companiesAndCompanyMemberList = companyService.findCompanyAndCompanyMember();


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


    /**
     * 企業情報を登録する.
     * @param companyRegisterForm
     * @return
     */
    @RequestMapping("/company/companyRegister")
    public String companyRegister(CompanyRegisterForm companyRegisterForm){

        Company companies = new Company();
        companies.setName(companyRegisterForm.getCompanyName());
        companies.setKana(companyRegisterForm.getCompanyKana());
        companies.setRemarks(companyRegisterForm.getRemarks());

        companyService.insertCompany(companies);

        return "redirect:/company/companyList";
    }


    /**
     * 企業担当者登録画面表示.
     * @return
     */
    @RequestMapping("/company/companyMemberDetailRegister")
    public String companyMemberDetailRegister(Model model){

        String id = httpServletRequest.getParameter("companyId");
        Integer companyId = Integer.parseInt(id);


        //企業を１件持ってくる
        Company company = companyService.findCompanyByCompanyId(companyId);

        //企業に紐づいている担当者を全員取得
        List<Company> companyMemberList =  companyService.findCompanyMemberAndCompanyByCompanyId(companyId);


        model.addAttribute("company", company);

        model.addAttribute("companyMemberList",companyMemberList);

        return "admin/company_register_charge";
    }



    @RequestMapping("company/companyMemberRegister")
    public String companyMemberRegister(){

        return "redirect:/company/companyRegister";
    }


}
