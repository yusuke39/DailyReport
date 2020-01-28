package com.example.DailyReport.service;

import com.example.DailyReport.domain.Admin;
import com.example.DailyReport.domain.AdminsCompanies;
import com.example.DailyReport.domain.Companies;
import com.example.DailyReport.form.LoginAdmin;
import com.example.DailyReport.form.RegisterAdminForm;
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
    public List<Admin> findAdmin(LoginAdmin loginAdmin){

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


    /**
     * 企業を全権取得する.
     * @return
     */
    public List<Companies> findAllCompanies(){
        return adminMapper.findAllCompanies();
    }


    /**
     * 管理者と管理者に紐づいた企業のリストをAdminドメインに詰めて、リストとして返す.
     * @return adminList
     *
     */
    public List<Admin> findAllAdminsAndCompanies(){

        return adminMapper.findAllAdminsAndCompanies();
    }


    public Admin findAdminAndCompanyByAdminId(String adminId){

        //Stringで受け取った管理者IDを数値に直す
        int id = Integer.parseInt(adminId);

        //管理者IDを元に管理者と企業テーブルを結合して、検索をかける
        Admin admins = adminMapper.findAdminsAndCompaniesByAdminId(id);

        //もし、企業が紐づいておらず、nullが返ってきたら管理者のみ検索して返す
        //(企業が紐づいていない＝すべての企業を閲覧する権限がある）
        if(admins == null){
           Admin admin =  adminMapper.findAdminById(id);
            return admin;
        }

        return admins;
    }


    /**
     * 管理者登録画面に入力された値をドメインに詰め、インサートに渡す.
     * @param registerAdminForm
     */
    public void registerAdminAndRelationCompanies(RegisterAdminForm registerAdminForm){

        //adminの情報をAdminドメインに詰める
        Admin admin = new Admin();
        admin.setName(registerAdminForm.getName());
        admin.setKana(registerAdminForm.getKana());
        admin.setEmail(registerAdminForm.getEmail());
        admin.setPassword(registerAdminForm.getPassword());
        admin.setCanShowAllCompany(registerAdminForm.isResponsibleCompany());
        adminMapper.insertAdmin(admin);

        //カンパニーリストを受け取る
        List<String> companiesId = registerAdminForm.getCompany();

        //カンパニーリストがnullだったらadmins_companiseにinsertmする必要がないので処理終了とする
        if(companiesId == null){
            return;
        }

        //カンパニーリストに値があれば、AdminsCompaniesドメインに
        AdminsCompanies adminsCompanies = new AdminsCompanies();
        adminsCompanies.setAdmins_id(admin.getId());


        //カンパニーリストの中の数字を数値に変換して、ドメインに詰める、リストに入っている会社の数だけインサート文を実行する.
        for(int i = 0; companiesId.size() > i; i ++){
            int companyId = Integer.parseInt(companiesId.get(i));
            adminsCompanies.setCompanies_id(companyId);
            adminMapper.insertAdminsIdAndCompaniesId(adminsCompanies);
        }
    }
}
