package com.example.DailyReport.service;

import com.example.DailyReport.AboutInstructor;
import com.example.DailyReport.Intelligibility;
import com.example.DailyReport.domain.DailyReport;
import com.example.DailyReport.domain.Student;
import com.example.DailyReport.domain.Training;
import com.example.DailyReport.form.DailyRegisterForm;
import com.example.DailyReport.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private ReuseMethod reuseMethod;





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

        //ReuseMethodにロジックを切り出し
        List<String> dayList =  reuseMethod.calculationDay(training);

        return dayList;
    }


    /**
     * 日報を検索する.
     * @param trainingId
     * @param studentId
     * @param date
     * @return
     */
    public DailyReport searchDairyReport(int trainingId, int studentId, Date date){

        //日付,studentId,trainingIdで日報を検索する
        DailyReport dailyReport =  studentMapper.findDairyReportByStudentIdAndTrainingIdAndDate(trainingId,studentId,date);


        //配列を用意して、enumで定義した値をリストに詰め直してます。(理解度用Ver)
        List<String> intelligibilityNumberList = new ArrayList<>();
        for(Intelligibility.IntelligibilityEnum intelligibility : Intelligibility.IntelligibilityEnum.values()){
            intelligibilityNumberList.add(intelligibility.getIntelligibility());
        }
        //dailyReportドメインから理解度の数字を取り出し変数へ。
        int intelligibilityNumber =  dailyReport.getIntelligibility();

        //理解度の数字によって、dairyReportのドメインに該当の文章を詰める
        switch (intelligibilityNumber){
            //1 = 良く理解できた
            case 1:
                dailyReport.setIntelligibilityEnumString(intelligibilityNumberList.get(0));
                break;
            //2 = 概ね理解できた
            case 2:
                dailyReport.setIntelligibilityEnumString(intelligibilityNumberList.get(1));
                break;
            //3 = 普通
            case 3:
                dailyReport.setIntelligibilityEnumString(intelligibilityNumberList.get(2));
                break;
            //4 = 少し難しかった
            case 4:
                dailyReport.setIntelligibilityEnumString(intelligibilityNumberList.get(3));
                break;
            //5 = とても難しかった
            case 5:
                dailyReport.setIntelligibilityEnumString(intelligibilityNumberList.get(4));
                break;
            default:
                break;
        }

        //配列を用意して、enumで定義した値をリストに詰め直してます。(講師への評価Ver)
        List<String> aboutInstructorList = new ArrayList<>();
        for(AboutInstructor.AboutInstructorEnum aboutInstructor : AboutInstructor.AboutInstructorEnum.values()){
            aboutInstructorList.add(aboutInstructor.getAboutInstructor());
        }

        int aboutInstructorNumber =  dailyReport.getAboutInstructor();
        //講師への評価の数字によって、dairyReportのドメインに該当の文章を詰める
        switch (aboutInstructorNumber){
            //1 = とても丁寧だった
            case 1:
                dailyReport.setAboutInstructorEnumString(aboutInstructorList.get(0));
                break;
            //2 = 概ね丁寧だった
            case 2:
                dailyReport.setAboutInstructorEnumString(aboutInstructorList.get(1));
                break;
            //3 = 普通
            case 3:
                dailyReport.setAboutInstructorEnumString(aboutInstructorList.get(2));
                break;
            //4 = やや丁寧ではなかった
            case 4:
                dailyReport.setAboutInstructorEnumString(aboutInstructorList.get(3));
                break;
            //5 = 全く丁寧ではなかった
            case 5:
                dailyReport.setAboutInstructorEnumString(aboutInstructorList.get(4));
                break;
            default:
                break;
        }


        return  dailyReport;
    }
}
