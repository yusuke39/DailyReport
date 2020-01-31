package com.example.DailyReport.controller;

import com.example.DailyReport.domain.Instructor;
import com.example.DailyReport.form.InstructorRegisterForm;
import com.example.DailyReport.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/instructor")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     * 講師一覧を表示する.
     * @param model
     * @return
     */
    @RequestMapping("/instructorList")
    public String instructorList(Model model){

        List<Instructor> instructorList = instructorService.findAllInstroctur();

        model.addAttribute("instructorList", instructorList);

        return "/admin/instructor_list";
    }


    /**
     * 講師新規登録画面を表示する.
     * @return
     */
    @RequestMapping("/instructorRegister")
    public String instructorRegister(){

        return "admin/instructor_detail";
    }


    /**
     * 講師を新規登録する.
     * @param instructorRegisterForm
     * @return
     */
    @RequestMapping("/instructorRegisterEnd")
    public String instructorRegisterEnd(InstructorRegisterForm instructorRegisterForm){

        instructorService.insertInstructor(instructorRegisterForm);

        return "redirect:/instructor/instructorList";
    }


    /**
     * 講師編集画面に遷移する.
     * @return
     */
    @RequestMapping("/instructorEdit")
    public String instructorEdit(Model model){

        String id =  httpServletRequest.getParameter("instructorId");
        int instructorId = Integer.parseInt(id);

        Instructor instructor = instructorService.findInstructorById(instructorId);

        model.addAttribute("instructor", instructor);

        return "admin/instructor_edit";
    }


    /**
     * 講師情報を編集する.
     * @param instructorRegisterForm
     * @return
     */
    @RequestMapping("/instructorEditEnd")
    public String instructorEditEnd(InstructorRegisterForm instructorRegisterForm){

        instructorService.updateInstructor(instructorRegisterForm);

        return "redirect:/instructor/instructorList";
    }
}
