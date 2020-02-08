package com.example.DailyReport.service;

import com.example.DailyReport.domain.DailyReport;
import com.example.DailyReport.domain.Student;
import com.example.DailyReport.domain.Training;
import com.example.DailyReport.form.DailyRegisterForm;
import com.example.DailyReport.form.StudentLoginForm;
import com.example.DailyReport.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TrainingService trainingService;


    /**
     * 受講生ログイン機能.
     * @param studentLoginForm
     * @return
     */
    public Student findStudentByEmailAndPassword(StudentLoginForm studentLoginForm){

        List<Student> studentList = studentMapper.findStudentByEmailAndPassword(studentLoginForm.getStudentEmail(), studentLoginForm.getStudentPassword());

        if(studentList.size() == 0){
            return null;
        }

        Student student = studentList.get(0);

        return student;
    }


    /**
     * 受講生IDを使って、関係している、研修と講師と企業を検索する.
     * @param studentId
     * @return
     */
    public List<Student> findAllTrainingRelationStudentByStudentId(int studentId){

        List<Student> studentList = studentMapper.findAllTrainingRelationStudentByStudentId(studentId);

        return studentList;
    }


    /**
     * 日報登録をする.
     * @param dailyRegisterForm
     */
    public void insertDairyReport(DailyRegisterForm dailyRegisterForm){

        LocalDate localDate = LocalDate.now();

        DailyReport dailyReport = new DailyReport();
        dailyReport.setDate(localDate);
        dailyReport.setTrainingId(dailyRegisterForm.getTrainingId());
        dailyReport.setStudentId(dailyRegisterForm.getStudentId());
        dailyReport.setContent(dailyRegisterForm.getContent());
        dailyReport.setIntelligibility(dailyRegisterForm.getIntelligibility());
        dailyReport.setDetailIntelligibility(dailyRegisterForm.getDetailIntelligibility());
        dailyReport.setAboutInstructor(dailyRegisterForm.getAboutInstructor());
        dailyReport.setQuestion(dailyRegisterForm.getQuestion());


        studentMapper.insertDairyReport(dailyReport);
    }


    /**
     * 研修の開始と終了を取得して、連続した日付を返す
     * @return
     */
    public List<String> BrowsingDairyReport(int trainingId){

        //研修IDを使って研修を検索する
        Training training = trainingService.findTrainingById(trainingId);
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
