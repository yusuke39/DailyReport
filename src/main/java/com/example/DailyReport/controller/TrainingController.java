package com.example.DailyReport.controller;

import com.example.DailyReport.domain.Instructor;
import com.example.DailyReport.domain.Training;
import com.example.DailyReport.form.TrainingRegisterForm;
import com.example.DailyReport.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/training")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     * 研修の一覧表示.,
     * @param model
     * @return
     */
    @RequestMapping("/adminTrainingList")
    public String adminTrainingList(Model model){

        List<Training> trainingList = trainingService.findAllTrainings();

        System.out.println(trainingList);

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


    /**
     * 編集画面に遷移する.
     * @param model
     * @return
     */
    @RequestMapping("/adminTrainingDetailEdit")
    public String adminTrainingDetailEdit(Model model){

        //研修IDを取得する.
        String id = httpServletRequest.getParameter("trainingId");
        Integer trainingId = Integer.parseInt(id);

        String id1 = httpServletRequest.getParameter("subInstructorId1");
        Integer subInstructorId1 = Integer.parseInt(id1);

          String id2 = httpServletRequest.getParameter("subInstructorId2");
//        Integer subInstructorId2 = Integer.parseInt(id2);
//
          String id3 = httpServletRequest.getParameter("subInstructorId3");
//        Integer subInstructorId3 = Integer.parseInt(id3);

        System.out.println("kkkkkk:" + id1);
        System.out.println("ffffff:" + id2);
        System.out.println("gggggg:" + id3);

        //研修IDを使って、研修、講師を検索
        Training training = trainingService.findTrainingById(trainingId);

        //講師を全権取得（selectタグで選択させるため）
        List<Instructor> instructorList = trainingService.findAllInstructor();

        model.addAttribute("instructorList",instructorList);

        model.addAttribute("training", training);

        return "/admin/admin_training_detail_edit";
    }


    /**
     * 研修を編集する.
     * @param trainingRegisterForm
     * @return
     */
    @RequestMapping("/adminTrainingDetailEditEnd")
    public String adminTrainingDetailEditEnd(TrainingRegisterForm trainingRegisterForm){

        trainingService.updateTraining(trainingRegisterForm);

        return "redirect:/training/adminTrainingList";
    }



}
