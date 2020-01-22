package com.example.DailyReport.service;

import com.example.DailyReport.domain.Admin;
import com.example.DailyReport.form.LoginAdmin;
import com.example.DailyReport.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;


    /**
     * 管理者のログイン情報を渡す.
     *
     * @param loginAdmin
     * @return 検索した１件の管理者情報.
     */
    public List<Admin> loginCheckAdmin(LoginAdmin loginAdmin){

        //帰ってきたドメインをリストに入れる
        List<Admin> adminList = adminMapper.findAdmin(loginAdmin.getEmail(),loginAdmin.getPassword());
        //もし、リストの中身が０ならぬっlを返す
        if(adminList.size() == 0){
            return null;
        }
        //リストからemailを抽出
        String email = adminList.get(0).getEmail();
        //リストからpasswordを抽出
        String password = adminList.get(0).getPassword();
        //入力されたメールアドレスとパスワードDBに入っていて、検索して取ってきたメールアドレスとパスワードと違ったらはじく
        if(!email.equals(loginAdmin.getEmail()) && !password.equals(loginAdmin.getPassword())){
            return null;
        }

        return adminList;
    }

}
