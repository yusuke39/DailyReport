package com.example.DailyReport.controller;

import com.example.DailyReport.domain.Instructor;
import com.example.DailyReport.domain.Training;
import com.example.DailyReport.service.InstructorService;
import com.example.DailyReport.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TrainingController {

    @Autowired
    private TrainingService trainingService;


    /**
     * 研修の一覧表示.,
     * @param model
     * @return
     */
    @RequestMapping("/training/adminTrainingList")
    public String adminTrainingList(Model model){

        List<Training> trainingList = trainingService.findAllTrainings();

        System.out.println(trainingList);

        model.addAttribute("trainingList",trainingList);

        return "admin/admin_training_list";
    }


    @RequestMapping("/training/adminTrainingDetail")
    public String adminTrainingDetail(Model model){

        return "admin/admin_training_detail";
    }


}
