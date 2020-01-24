package com.example.DailyReport.mapper;

import com.example.DailyReport.domain.Admin;
import com.example.DailyReport.domain.AdminsAndCompanies;
import com.example.DailyReport.domain.Companies;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {


    /**
     * 管理者を1件検索する.
     *
     * @param email,password
     * @return 管理者を１件検索して返す.
     */
    List<Admin> findAdmin(@Param("email")String email, @Param("password")String password);



    /**
     * Admin,Company,Admins_companiesを結合して、検索する.
     * @return
     */
    List<Admin> findAllAdminsAndCompanies();

}
