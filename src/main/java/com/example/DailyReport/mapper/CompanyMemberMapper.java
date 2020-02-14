package com.example.DailyReport.mapper;

import com.example.DailyReport.domain.CompanyMember;
import com.example.DailyReport.domain.Student;
import com.example.DailyReport.domain.Training;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CompanyMemberMapper {


    /**
     * 企業担当者を１件検索する
     * @param email
     * @return
     */
    public CompanyMember findCompanyMemberByEmail(String email);


    /**
     * 企業（企業担当者）に紐づいている、担当者、受講生、研修、講師を受講生の企業IDにて検索する
     * @param companyId
     * @return
     */
    public List<Training> findAllTrainingRelationCompanyByCompanyId(int companyId);

}
