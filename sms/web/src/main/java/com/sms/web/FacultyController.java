package com.sms.web;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/faculty")
public class FacultyController {

    @RequestMapping("/login")
    public String login(){
        return "faculty/login";
    }

    @RequestMapping("/list")
    public String list(){
        return "faculty/list";
    }
}
