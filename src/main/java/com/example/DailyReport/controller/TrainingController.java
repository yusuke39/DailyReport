package com.example.DailyReport.controller;

import com.example.DailyReport.domain.Instructor;
import com.example.DailyReport.domain.Training;
import com.example.DailyReport.form.TrainingRegisterForm;
import com.example.DailyReport.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.List;

@Controller
@RequestMapping("/training")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;


    /**
     * 研修の一覧表示.,
     * @param model
     * @return
     */
    @RequestMapping("/adminTrainingList")
    public String adminTrainingList(Model model){

        List<Training> trainingList = trainingService.findAllTrainings();


        model.addAttribute("trainingList",trainingList);

        return "admin/admin_training_list";
    }


    /**
     * 研修新規登録画面表示
     * @param model
     * @return
     */
    @RequestMapping("/adminTrainingDetail")
    public String adminTrainingDetail(Model model){

        List<Instructor> instructorList = trainingService.findAllInstructor();

        model.addAttribute("instructorList",instructorList);

        return "admin/admin_training_detail";
    }

    /**
     * 研修新規登録
     * @param trainingRegisterForm
     * @return
     */
    @RequestMapping("/insertTraining")
    public String insertTraining(TrainingRegisterForm trainingRegisterForm){

        trainingService.insertTraining(trainingRegisterForm);

        return "redirect:/training/adminTrainingList";
    }


    @RequestMapping("/adminTrainingDetailEdit")
    public String adminTrainingDetailEdit(){

        return "/admi/admin_training_detail_edit";
    }


    @RequestMapping("/adminTrainingDetailEditEnd")
    public String adminTrainingDetailEditEnd(){
        return "";
    }



}
