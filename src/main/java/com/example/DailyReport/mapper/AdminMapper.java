package com.example.DailyReport.mapper;

import com.example.DailyReport.domain.Admin;
import com.example.DailyReport.domain.AdminsCompanies;
import com.example.DailyReport.domain.Companies;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {


    /**
     * 管理者を１件検索する.
     * @param id
     * @return
     */
    Admin findAdminById(int id);

    /**
     * 管理者を1件検索する.
     *
     * @param email,password
     * @return 管理者を１件検索して返す.
     */
    List<Admin> findAdmin(String email);


    /**
     * admins_companiesテーブルから管理者IDを使って1件検索する.
     * @param adminsId
     * @return
     */
    List<AdminsCompanies> findAdminsCompaniesById(int adminsId);


    /**
     * 管理者IDを使って、admins_companiesテーブルから削除する.
     * @param adminsId
     * @return
     */
    void deleteAdminCompaniesByAdminsId(int adminsId);


    /**
     * 管理者と企業を１件結合して検索する.
     * @param adminId
     * @return
     */
    Admin findAdminsAndCompaniesByAdminId(int adminId);


    /**
     * 企業を全権取得する.
     * @return
     */
    List<Companies> findAllCompanies();

    /**
     * Admin,Company,Admins_companiesを結合して、検索する.
     * @return
     */
    List<Admin> findAllAdminsAndCompanies();


    /**
     * 管理者情報を登録する
     * @param admin
     */
    int insertAdmin(Admin admin);


    /**
     * admins_companiesテーブルに管理者IDと企業IDを登録する.
     * @param adminsCompanies
     */
    void insertAdminsIdAndCompaniesId(AdminsCompanies adminsCompanies);


    /**
     * 管理者情報をアップデートする.
     * @param admin
     */
    void updateAdmin(Admin admin);

}
