package com.example.DailyReport.mapper;

import com.example.DailyReport.domain.Admin;
import com.example.DailyReport.domain.Company;
import com.example.DailyReport.domain.CompanyMember;
import com.example.DailyReport.form.CompanyMemberRegisterForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyMapper {

    /**
     * 企業、企業担当者、companies_company_membersを結合して、全件取得する.
     * @return
     */
    List<Admin> findAllCompanyMemberAndCompaniesByAdminId(int adminId);


    /**
     * 企業を全権検索する.
     * @return
     */
    List<Company> findAllCompanies();


    /**
     * 企業IDで検索して紐づいている担当者を検索する.
     * @param companyId
     * @return
     */
    List<Company> findCompanyMemberAndCompanyByCompanyId(int companyId);

    /**
     * 企業を１件検索する.
     * @param companyId
     * @return
     */
    public Company findCompanyByCompanyId(int companyId);


    /**
     * 企業情報をinsertする.
     * @param companies
     * @return
     */
    void insertCompany(Company companies);

    /**
     * 企業担当をinsertする.
     * @param companyMember
     */
    int insertCompanyMember(CompanyMember companyMember);

    /**
     * 企業IDと担当者IDをinsertする.
     * @param companiesId
     * @param companyMembersId
     */
    void insertCompaniesCompanyMembers(int companiesId, int companyMembersId);

    /**
     * 企業をupdateする.
     * @param company
     */
    void updateCompany(Company company);


}
