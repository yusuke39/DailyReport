package com.example.DailyReport.controller;

import com.example.DailyReport.domain.Instructor;
import com.example.DailyReport.domain.Training;
import com.example.DailyReport.form.TrainingRegisterForm;
import com.example.DailyReport.service.InstructorService;
import com.example.DailyReport.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private InstructorService instructorService;

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

        return "redirect:/admin/adminTrainingList";
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


//        if(httpServletRequest.getParameter("subInstructorId1") != "" &&
//                httpServletRequest.getParameter("subInstructorId2") != "" &&
//                httpServletRequest.getParameter("subInstructorId3") != ""){
//            //サブ講師ID1を取得
//            String id1 = httpServletRequest.getParameter("subInstructorId1");
//            Integer subInstructorId1 = Integer.parseInt(id1);
//            //サブ講師ID2を取得
//            String id2 = httpServletRequest.getParameter("subInstructorId2");
//            Integer subInstructorId2 = Integer.parseInt(id2);
//            //サブ講師ID3を取得
//            String id3 = httpServletRequest.getParameter("subInstructorId3");
//            Integer subInstructorId3 = Integer.parseInt(id3);
//
//            //研修IDを使って、研修、講師を検索
//            Instructor subInstructor1 = instructorService.findInstructorById(subInstructorId1);
//            Instructor subInstructor2 = instructorService.findInstructorById(subInstructorId2);
//            Instructor subInstructor3 = instructorService.findInstructorById(subInstructorId3);
//            model.addAttribute("subInstructor1",subInstructor1);
//            model.addAttribute("subInstructor2",subInstructor2);
//            model.addAttribute("subInstructor3",subInstructor3);
////        }


//        //もし、１のパラメーターが空出ないなら、modelに入れない
//        //空の場合は
//        if(httpServletRequest.getParameter("subInstructorId1") != ""){
//            //サブ講師ID1を取得
//            String id1 = httpServletRequest.getParameter("subInstructorId1");
//            Integer subInstructorId1 = Integer.parseInt(id1);
//            Instructor subInstructor1 = instructorService.findInstructorById(subInstructorId1);
//            model.addAttribute("subInstructor1",subInstructor1);
//        } else {
//            model.addAttribute("empty","選択して下さい");
//        }
//
//        if(httpServletRequest.getParameter("subInstructorId2") != ""){
//            //サブ講師ID1を取得
//            String id2 = httpServletRequest.getParameter("subInstructorId2");
//            Integer subInstructorId2 = Integer.parseInt(id2);
//            Instructor subInstructor2 = instructorService.findInstructorById(subInstructorId2);
//            model.addAttribute("subInstructor1",subInstructor2);
//        } else {
//            model.addAttribute("empty","選択して下さい");
//        }
//
//        if(httpServletRequest.getParameter("subInstructorId3") != ""){
//            //サブ講師ID1を取得
//            String id3 = httpServletRequest.getParameter("subInstructorId3");
//            Integer subInstructorId3 = Integer.parseInt(id3);
//            Instructor subInstructor3 = instructorService.findInstructorById(subInstructorId3);
//            model.addAttribute("subInstructor1",subInstructor3);
//        } else {
//            model.addAttribute("empty","選択して下さい");
//        }


        //研修を１件取得
        Training training = trainingService.findTrainingById(trainingId);
        model.addAttribute("training", training);

        //講師を全権取得（selectタグで選択させるため）
        List<Instructor> instructorList = trainingService.findAllInstructor();
        model.addAttribute("instructorList",instructorList);


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

        return "redirect:/admin/adminTrainingList";
    }



}
