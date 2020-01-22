package com.example.DailyReport.service;

import com.example.DailyReport.domain.Admin;
import com.example.DailyReport.form.LoginAdmin;
import com.example.DailyReport.mapper.LoginAdminsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoginAdminService {

    @Autowired
    private LoginAdminsMapper loginAdminsMapper;


    /**
     * 管理者のログイン情報を渡す.
     *
     * @param loginAdmin
     * @return 検索した１件の管理者情報.
     */
    public List<Admin> loginCheckAdmin(LoginAdmin loginAdmin){

        //帰ってきたドメインをリストに入れる
        List<Admin> adminList = loginAdminsMapper.findAdmin(loginAdmin.getEmail(),loginAdmin.getPassword());


        //もし、リストの中身が０ならぬっlを返す
        if(adminList.size() == 0){
            System.out.println("0だよ");
            return null;
        }

        //リストからemailを抽出
        String email = adminList.get(0).getEmail();
        //リストからpasswordを抽出
        String password = adminList.get(0).getPassword();

        if(!email.equals(loginAdmin.getEmail()) && !password.equals(loginAdmin.getPassword())){
            System.out.println("合わないよ");
            return null;
        }

        return adminList;
    }

}
