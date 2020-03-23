package com.sms.service;

import com.sms.dao.IFacultyInfoDao;
import com.sms.model.FacultyInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyInfoService {
    @Autowired
    private IFacultyInfoDao facultyInfoDao;

    public List<FacultyInfo> getAllFacultyInfos(){
        return this.facultyInfoDao.getAllFacultyInfos();
    }

    public FacultyInfo get(long id){
        return this.facultyInfoDao.get(id);
    }

    public List<FacultyInfo> getByName(String name){
        return this.facultyInfoDao.getFacultyInfoByName(name);
    }

    public void addFacultyInfo(FacultyInfo facultyInfo){
        this.facultyInfoDao.addFacultyInfo(facultyInfo);
    }

    public void updateFacultyInfo(FacultyInfo facultyInfo){
        this.facultyInfoDao.update(facultyInfo);
    }

    public void deleteFacultyInfo(long id){
        this.facultyInfoDao.delete(id);
    }
}
