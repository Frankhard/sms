package com.sms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/stu")
public class StudentInfoController {
    @RequestMapping("/list")
    public String list(){
        return "stu/list";
    }
    @RequestMapping("/add")
    public String add(){
        return "stu/add";
    }

    @RequestMapping("/update")
    public String delete(){
        return "stu/update";
    }

    @RequestMapping("/login")
    public String login(){
        return "stu/login";
    }
}
