package com.example.DailyReport.controller;

import com.example.DailyReport.domain.Instructor;
import com.example.DailyReport.form.InstructorRegisterForm;
import com.example.DailyReport.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    /**
     * 講師一覧を表示する.
     * @param model
     * @return
     */
    @RequestMapping("/instructor/instructorList")
    public String instructorList(Model model){

        List<Instructor> instructorList = instructorService.findAllInstroctur();

        model.addAttribute("instructorList", instructorList);

        return "/admin/instructor_list";
    }


    /**
     * 講師新規登録画面を表示する.
     * @return
     */
    @RequestMapping("/instructor/instructorRegister")
    public String instructorRegister(){

        return "admin/instructor_detail";
    }


    /**
     * 講師を新規登録する.
     * @param instructorRegisterForm
     * @return
     */
    @RequestMapping("/instructor/instructorRegisterEnd")
    public String instructorRegisterEnd(InstructorRegisterForm instructorRegisterForm){

        instructorService.insertInstructor(instructorRegisterForm);

        return "redirect:/instructor/instructorList";
    }

}
