package com.sms.api;

import com.sms.model.FacultyInfo;
import com.sms.model.ResponseModel;
import com.sms.service.FacultyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyInfoController {
    @Autowired
    private FacultyInfoService facultyInfoService;

    @RequestMapping("/list")
    public List<FacultyInfo> list(){
        return this.facultyInfoService.getAllFacultyInfos();
    }

    @RequestMapping("/get")
    public FacultyInfo get(long id){
        return this.facultyInfoService.get(id);
    }

    @RequestMapping("/searchByName")
    public List<FacultyInfo> searchByName(String name){
        return this.facultyInfoService.getByName(name);
    }

    @RequestMapping("/add")
    public ResponseModel add(FacultyInfo facultyInfo){
        try {
            this.facultyInfoService.addFacultyInfo(facultyInfo);
            return new ResponseModel(true,"200");
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseModel(false,ex.getMessage());
        }
    }

    @RequestMapping("/delete")
    public ResponseModel delete(long id){

        try {
            this.facultyInfoService.deleteFacultyInfo(id);
            return new ResponseModel(true,"200");
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseModel(false,ex.getMessage());
        }
    }

    @RequestMapping("/update")
    public ResponseModel update(FacultyInfo facultyInfo){
        try {
            this.facultyInfoService.updateFacultyInfo(facultyInfo);
            return new ResponseModel(true,"200");
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseModel(false,ex.getMessage());
        }
    }
}
