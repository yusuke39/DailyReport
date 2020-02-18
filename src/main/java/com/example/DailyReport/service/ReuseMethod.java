package com.example.DailyReport.service;

import com.example.DailyReport.domain.Training;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class ReuseMethod {

    public List<String> calculationDay(Training training){
        //研修の始まりの日を取得する.
        LocalDate startDate = training.getStartDate();
        //研修終了の日を年、月、日に分けて、数値にする.
        int startYear = startDate.getYear();
        int startMonth = startDate.getMonthValue();
        int startDay = startDate.getDayOfMonth();
        //研修終了の日取得
        LocalDate endDate = training.getEndDate();

        //研修の始まりの日と終わりの日の差分を計算する.
        long diffDays = ChronoUnit.DAYS.between(startDate , endDate);

        //カレンダーを使って、研修の始まりと終わりの差分だけ、for文で回し、リストに年月日を入れて返す.
        Calendar calendar = Calendar.getInstance();
        calendar.set(startYear,startMonth,startDay);
        List<String> dayList = new ArrayList<>();
        for(int i = 0; i <= diffDays; i ++){
            dayList.add(calendar.get(Calendar.YEAR) + "/" + calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.DATE));
            calendar.add(Calendar.DATE, 1);
        }

        return dayList;
    }


}
