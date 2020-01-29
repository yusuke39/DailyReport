package com.example.DailyReport.service;

import com.example.DailyReport.domain.Company;
import com.example.DailyReport.domain.CompanyMember;
import com.example.DailyReport.form.CompanyMemberRegisterForm;
import com.example.DailyReport.form.CompanyRegisterForm;
import com.example.DailyReport.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Company> findCompanyAndCompanyMember(){

        List<Company> companiesAndCompanyMemberList = companyMapper.findAllCompanyMemberAndCompanies();

        return companiesAndCompanyMemberList;
    }



//    public Company findCompanyMemberAndCompanyByMemberId(int companyMemberId){
//
//        //ログインしている担当者に紐づいている企業を検索する
//        Company company = companyMapper.findCompanyMemberAndCompanyByMemberId(companyMemberId);
//
//        return company;
//    }


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


    public void insertCompanyMember(CompanyMemberRegisterForm companyRegisterForm){


        //CompanyMemberにインサートする
        CompanyMember companyMember = new CompanyMember();
        companyMember.setName(companyRegisterForm.getCompanyMemberName());
        companyMember.setKana(companyRegisterForm.getCompanyMemberKana());
        companyMember.setEmail(companyRegisterForm.getCompanyMemberEmail());
        companyMember.setPassword(companyRegisterForm.getCompanyMemberPassword());
        companyMapper.insertCompanyMember(companyMember);

        //companies_company_membersにインサートする
        int companyId = companyRegisterForm.getCompanyId();
        int companyMemberId = companyMember.getId();
        companyMapper.insertCompaniesCompanyMembers(companyId,companyMemberId);

    }

}
