package com.example.DailyReport.controller;

import com.example.DailyReport.domain.Admin;
import com.example.DailyReport.domain.Companies;
import com.example.DailyReport.form.LoginAdmin;
import com.example.DailyReport.form.RegisterAdminForm;
import com.example.DailyReport.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * ログイン画面表示.
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {

        return "admin/admin_login";
    }


    /**
     * ログインユーザー（管理者）が正しいかemailとパスワードで判断する.
     *
     * @param loginAdmin
     * @param model
     * @return
     */
    @RequestMapping("/checkAdmin")
    public String checkAdmin(LoginAdmin loginAdmin, Model model) {
        List<Admin> admin = adminService.loginCheckAdmin(loginAdmin);

        if (admin == null) {
            model.addAttribute("loginError", "メールアドレスかパスワードが正しくありません");
            return "admin/admin_login";
        }

        return "admin/admin_training_list";
    }


    /**
     * 運営管理車一覧表示.
     *
     * @return
     */
    @RequestMapping("/operationManager")
    public String operationManager(Model model) {

        List<Admin> adminList = adminService.findAllAdminsAndCompanies();

        model.addAttribute("adminList", adminList);

        return "admin/facility_manager_list";
    }


    /**
     * 運営管理者登録画面を表示する.
     * @return
     */
    @RequestMapping("/registerAdmin")
    public String registerAdmin(Model model){

        List<Companies> companyList = adminService.findAllCompanies();

        model.addAttribute("companyList", companyList);

        return "admin/facility_manager_detail";
    }


    /**
     * 管理者情報を登録する.
     * @param registerAdminForm
     * @return
     */
    @RequestMapping("/registerAdminDetail")
    public String registerAdminDetail(RegisterAdminForm registerAdminForm){

        adminService.registerAdminAndRelationCompanies(registerAdminForm);

        return "redirect:/operationManager";
    }
}
