package com.apptechstudent.controller;
import com.apptechstudent.entity.Student;
import com.apptechstudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String showLoginPage()
    {
        return "student/login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public String showListStudent(Model model){
            model.addAttribute("listStudent", studentService.getList(1, 10));
            return "student/list";

    }
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String getDetail(@PathVariable int id, Model model){
        model.addAttribute("student", studentService.getDetail(id));
        return "student/detail";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String createNewStudent(Model model){
        model.addAttribute("student", new Student());
        return "student/form";
    }


    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String storeStudent(@Valid Student student, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "student/form";
        }
        studentService.register(student);
        return "student/list";
    }
}
