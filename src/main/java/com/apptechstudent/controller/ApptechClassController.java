package com.apptechstudent.controller;

import com.apptechstudent.service.ApptechClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/apptech-class")
public class ApptechClassController {
    @Autowired

    ApptechClassService apptechClassService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public String showListFlower(Model model) {
        model.addAttribute("list-class-aptech", apptechClassService.getList(1, 10));
        return "student/aptech-class/list";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String getDetail(@PathVariable int id, Model model){
        model.addAttribute("aptech-class", apptechClassService.getDetail(id));
        return "student/aptech-class/detail";

    }
}
