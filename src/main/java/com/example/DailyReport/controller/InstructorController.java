package com.example.DailyReport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InstructorController {

    @RequestMapping("/instructor/instructorList")
    public String instructorList(){

        return "/admin/instructor_list";
    }

}
