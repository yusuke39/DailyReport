package com.example.DailyReport.mapper;

import com.example.DailyReport.domain.Companies;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyMapper {

    /**
     * 企業、企業担当者、companies_company_membersを結合して、全件取得する.
     * @return
     */
    List<Companies> findAllCompanyMemberAndCompanies();



}
