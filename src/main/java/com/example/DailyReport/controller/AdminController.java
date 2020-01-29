package com.example.DailyReport.controller;

import com.example.DailyReport.domain.Admin;
import com.example.DailyReport.domain.Companies;
import com.example.DailyReport.form.AdminEditForm;
import com.example.DailyReport.form.LoginAdmin;
import com.example.DailyReport.form.RegisterAdminForm;
import com.example.DailyReport.mapper.AdminMapper;
import com.example.DailyReport.service.AdminService;
import com.example.DailyReport.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import java.util.List;


@Controller
@RequestMapping("")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private HttpServletRequest httpServletRequest;



    /**
     * ログイン画面表示.
     *
     * @return
     */
    @RequestMapping("/admin/login")
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
    @RequestMapping("/admin/checkAdmin")
    public String checkAdmin(LoginAdmin loginAdmin, Model model) {
        List<Admin> admin = adminService.findAdmin(loginAdmin);

        if (admin == null) {
            model.addAttribute("loginError", "メールアドレスかパスワードが正しくありません");
            return "admin/admin_login";
        }

        int adminId = admin.get(0).getId();


        return "admin/admin_training_list";
    }


    /**
     * 運営管理者一覧表示.
     *
     * @return
     */
    @RequestMapping("/admin/operationManager")
    public String operationManager(Model model) {

        List<Admin> adminList = adminService.findAllAdminsAndCompanies();

        model.addAttribute("adminList", adminList);

        return "admin/facility_manager_list";
    }


    /**
     * 運営管理者登録画面を表示する.
     *
     * @return
     */
    @RequestMapping("/admin/registerAdmin")
    public String registerAdmin(Model model) {

        List<Companies> companyList = adminService.findAllCompanies();

        model.addAttribute("companyList", companyList);

        return "admin/facility_manager_detail";
    }


    /**
     * 管理者情報を登録する.
     *
     * @param registerAdminForm
     * @return
     */
    @RequestMapping("/admin/registerAdminDetail")
    public String registerAdminDetail(RegisterAdminForm registerAdminForm, Model model) {

//        if(!(registerAdminForm.getPassword() == registerAdminForm.getConfirmPassword())){
//            model.addAttribute("passwordMismatch","パスワードと確認用パスワードが一致しません");
//            return "admin/facility_manager_detail";
//        }

        adminService.registerAdminAndRelationCompanies(registerAdminForm);

        return "redirect:/admin/operationManager";
    }


    /**
     * 管理者編集画面に遷移する.
     *
     * @param model
     * @return
     */
    @RequestMapping("/admin/editAdmin")
    public String editAdmin(Model model) {

        //リクエストパラメーターの値を受け取る
        String adminId = httpServletRequest.getParameter("adminId");

        //管理者と企業を１件探す
        Admin admin = adminService.findAdminAndCompanyByAdminId(adminId);

        //企業情報を全権取得する
        List<Companies> companiesList = adminMapper.findAllCompanies();

        model.addAttribute("companiesList", companiesList);

        model.addAttribute("admin", admin);

        return "admin/admin_manager_detail_edit";
    }


    /**
     * 管理者情報を編集する.
     *
     * @param adminEditForm
     * @return
     */
    @RequestMapping("/admin/editAdminDetail")
    public String editAdminDetail(AdminEditForm adminEditForm) {

        adminService.editAdminAndRelationCompanies(adminEditForm);

        return "redirect:/admin/operationManager";
    }


    /**
     * 企業と関連する企業担当者を全件表示する.
     * @return
     */
    @RequestMapping("/admin/companyList")
    public String companyList(Model model) {

        List<Companies> companiesAndCompanyMemberList = companyService.findCompanyAndCompanyMember();


        model.addAttribute("companiesAndCompanyMemberList" ,companiesAndCompanyMemberList);

        return "admin/company_list";
    }
}