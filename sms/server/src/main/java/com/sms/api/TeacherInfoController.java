package com.sms.api;

import com.sms.model.ResponseModel;
import com.sms.model.TeacherInfo;
import com.sms.service.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher")
public class TeacherInfoController {
    @Autowired
    private TeacherInfoService teacherInfoService;

    @RequestMapping("/get")
    public TeacherInfo getByNo(String no){
        return this.teacherInfoService.getByNo(no);
    }

    @RequestMapping("/add")
    public ResponseModel add(TeacherInfo teacherInfo){
        try{
            this.teacherInfoService.add(teacherInfo);
            return new ResponseModel(true,"200");
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseModel(false,ex.getMessage());
        }
    }

    @RequestMapping("/update")
    public ResponseModel update(TeacherInfo teacherInfo){
        try{
            this.teacherInfoService.update(teacherInfo);
            return new ResponseModel(true,"200");
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseModel(false,ex.getMessage());
        }
    }
}
