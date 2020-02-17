package com.example.DailyReport.service;


import com.example.DailyReport.domain.DailyReport;
import com.example.DailyReport.domain.Training;
import com.example.DailyReport.mapper.CompanyMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyMemberService {

    @Autowired
    private CompanyMemberMapper companyMemberMapper;


    /**
     * 企業と関連のある研修を検索する.
     * @param companyId
     * @return
     */
    public List<Training> findAllTrainingRelationCompanyByCompanyId(int companyId){

        List<Training> trainingList = companyMemberMapper.findAllTrainingRelationCompanyByCompanyId(companyId);

        return trainingList;
    }


    /**
     * 研修に関係している、日報と受講生を検索する.
     * @param trainingId
     * @return
     */
    public List<DailyReport> findDairyReportAndStudentAndTraining(int trainingId, int companyId){

        List<DailyReport> dailyReportList = companyMemberMapper.findDairyReportAndStudentAndTraining(trainingId, companyId);

        return dailyReportList;
    }


}
