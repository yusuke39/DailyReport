package com.example.DailyReport.service;


import com.example.DailyReport.domain.Training;
import com.example.DailyReport.mapper.CompanyMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyMemberService {

    @Autowired
    private CompanyMemberMapper companyMemberMapper;

    public List<Training> findAllTrainingRelationCompanyByCompanyId(int companyId){

        List<Training> trainingList = companyMemberMapper.findAllTrainingRelationCompanyByCompanyId(companyId);

        return trainingList;
    }
}
