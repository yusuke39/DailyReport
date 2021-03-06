package com.example.DailyReport.controller;

import com.example.DailyReport.domain.Admin;
import com.example.DailyReport.domain.Company;
import com.example.DailyReport.form.CompanyMemberRegisterForm;
import com.example.DailyReport.form.CompanyRegisterForm;
import com.example.DailyReport.security.Admin.LoginAdmin;
import com.example.DailyReport.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private HttpServletRequest httpServletRequest;



    /**
     * 企業と関連する企業担当者を全件表示する.
     * @return
     */
    @RequestMapping("/companyList")
    public String companyList(Model model, @AuthenticationPrincipal LoginAdmin loginAdmin) {

        List<Admin> adminAndCompaniesList = companyService.findCompanyAndCompanyMember(loginAdmin.getAdmin().getId());

        //もし、全ての企業が見れる権限があれえば、会社を全権表示させる
        if(adminAndCompaniesList.get(0).isCanShowAllCompany() == true){
            List<Company> companyList = companyService.findAllCompanies();
            model.addAttribute("companyList", companyList);
        }

        model.addAttribute("adminAndCompaniesList" ,adminAndCompaniesList);

        return "admin/company_list";
    }


    /**
     * 企業新規登録画面を表示
     * @return
     */
    @RequestMapping("/companyDetailRegister")
    public String companyDetailRegister(){
        return"admin/company_detail";
    }


    /**
     * 企業情報を登録する.
     * @param companyRegisterForm
     * @return
     */
    @RequestMapping("/companyRegister")
    public String companyRegister(CompanyRegisterForm companyRegisterForm){

        companyService.insertCompany(companyRegisterForm);

        return "redirect:/admin/companyList";
    }


    /**
     * 企業担当者登録画面表示.
     * @return
     */
    @RequestMapping("/companyMemberDetailRegister")
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


    /**
     * 企業担当者登録機能.
     * @param companyRegisterForm
     * @return
     */
    @RequestMapping("/companyMemberRegister")
    public String companyMemberRegister(CompanyMemberRegisterForm companyRegisterForm){

        companyService.insertCompanyMember(companyRegisterForm);

        return "redirect:/admin/companyList";
    }


    /**
     * 企業編集画面表示.
     * @param model
     * @return
     */
    @RequestMapping("/companyEdit")
    public String companyEdit(Model model){

      //パラメーター（companyId)を受け取る
      String id =  httpServletRequest.getParameter("companyId");
      int companyId = Integer.parseInt(id);

      //企業を１件検索する
      Company company = companyService.findCompanyByCompanyId(companyId);

      model.addAttribute("company", company);

        return "admin/company_detail_edit";
    }


    /**
     * 企業を編集する.
     * @param companyRegisterForm
     * @return
     */
    @RequestMapping("/companyEditEnd")
    public String companyEditEnd(CompanyRegisterForm companyRegisterForm){

        companyService.updateCompany(companyRegisterForm);

        return "redirect:/admin/companyList";
    }




}
