package com.example.DailyReport.service;

import com.example.DailyReport.domain.Admin;
import com.example.DailyReport.domain.Company;
import com.example.DailyReport.domain.CompanyMember;
import com.example.DailyReport.form.CompanyMemberRegisterForm;
import com.example.DailyReport.form.CompanyRegisterForm;
import com.example.DailyReport.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyMapper companyMapper;


    /**
     * 企業一覧と企業担当者を全件検索する.
     * @return
     */
    public List<Admin> findCompanyAndCompanyMember(int adminId){

        List<Admin> companiesAndCompanyMemberList = companyMapper.findAllCompanyMemberAndCompaniesByAdminId(adminId);
        return companiesAndCompanyMemberList;
    }


    /**
     * 会社を全権検索する.
     * @return
     */
    public List<Company> findAllCompanies(){
        List<Company> companyList = companyMapper.findAllCompanies();
        return companyList;
    }



    /**
     * 企業に紐づいている担当社一覧を検索する.
     * @param companyId
     * @return
     */
    public  List<Company> findCompanyMemberAndCompanyByCompanyId(int companyId){

        List<Company> companyMembersList = companyMapper.findCompanyMemberAndCompanyByCompanyId(companyId);

        return companyMembersList;
    }


    /**
     * 企業を１件検索する.
     * @param companyId
     * @return
     */
    public Company findCompanyByCompanyId(int companyId){

        Company company = companyMapper.findCompanyByCompanyId(companyId);

        return company;
    }


    /**
     * 企業情報を登録する.
     * @param companyRegisterForm
     */
    public void insertCompany(CompanyRegisterForm companyRegisterForm){
        Company companies = new Company();
        companies.setName(companyRegisterForm.getCompanyName());
        companies.setKana(companyRegisterForm.getCompanyKana());
        companies.setRemarks(companyRegisterForm.getRemarks());

        companyMapper.insertCompany(companies);

    }


    /**
     * 企業担当と企業担当IDと企業IDを中間テーブルにinsert
     * @param companyRegisterForm
     */
    public void insertCompanyMember(CompanyMemberRegisterForm companyRegisterForm){

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password =  bCryptPasswordEncoder.encode(companyRegisterForm.getCompanyMemberPassword());

        //CompanyMemberにインサートする
        CompanyMember companyMember = new CompanyMember();
        companyMember.setName(companyRegisterForm.getCompanyMemberName());
        companyMember.setKana(companyRegisterForm.getCompanyMemberKana());
        companyMember.setEmail(companyRegisterForm.getCompanyMemberEmail());
        companyMember.setPassword(password);
        companyMapper.insertCompanyMember(companyMember);

        //companies_company_membersにインサートする
        int companyId = companyRegisterForm.getCompanyId();
        int companyMemberId = companyMember.getId();//自動裁判で取ってくる
        companyMapper.insertCompaniesCompanyMembers(companyId,companyMemberId);
    }


    /**
     * 企業情報を編集する.
     * @param companyRegisterForm
     */
    public void updateCompany(CompanyRegisterForm companyRegisterForm){

        Company company = new Company();
        company.setId(companyRegisterForm.getId());
        company.setName(companyRegisterForm.getCompanyName());
        company.setKana(companyRegisterForm.getCompanyKana());
        company.setRemarks(companyRegisterForm.getRemarks());
        companyMapper.updateCompany(company);

    }

}
