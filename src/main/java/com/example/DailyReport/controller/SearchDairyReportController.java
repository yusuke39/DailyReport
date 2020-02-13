package com.example.DailyReport.controller;

import com.example.DailyReport.domain.DailyReport;
import com.example.DailyReport.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/student")
public class SearchDairyReportController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private HttpServletRequest httpServletRequest;


    @RequestMapping("/searchDairyReport")
    public List<DailyReport> searchDairyReport() throws ParseException {

        int trainingId = Integer.parseInt(httpServletRequest.getParameter("trainingId"));

        int studentId = Integer.parseInt(httpServletRequest.getParameter("studentId"));

        String day = httpServletRequest.getParameter("day");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = simpleDateFormat.parse(day);


        DailyReport dailyReport = studentService.searchDairyReport(trainingId,studentId,date);

        List<DailyReport> dailyReportList =  Arrays.asList(dailyReport);

        return dailyReportList;
    }
}
