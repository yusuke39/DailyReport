package com.example.DailyReport.controller;

import com.example.DailyReport.domain.Admin;
import com.example.DailyReport.form.LoginAdmin;
import com.example.DailyReport.service.LoginAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("")
public class AdminController {

    @Autowired
    private LoginAdminService loginAdminService;

    /**
     * ログイン画面表示.
     *
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "admin/admin_login";
    }


    @RequestMapping("/checkAdmin")
    public String checkAdmin(LoginAdmin loginAdmin, Model model){
       List<Admin> admin =  loginAdminService.loginCheckAdmin(loginAdmin);

       if(admin == null){
           model.addAttribute("メールアドレスかパスワードが正しくありません");
           return "admin/admin_login";
      }

        return "admin/admin_training_list";
    }


}
