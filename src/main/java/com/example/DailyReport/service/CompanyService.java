package com.example.DailyReport.service;

import com.example.DailyReport.domain.Companies;
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
    public List<Companies> findCompanyAndCompanyMember(){

        List<Companies> companiesAndCompanyMemberList = companyMapper.findAllCompanyMemberAndCompanies();

        return companiesAndCompanyMemberList;
    }

}
