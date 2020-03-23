package com.sms.service;

import com.sms.dao.ITeacherInfoDao;
import com.sms.model.TeacherInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherInfoService {

    @Autowired
    private ITeacherInfoDao teacherInfoDao;

    public Boolean checkPassword(String no,String pwd){
        try{
            TeacherInfo teacherInfo=this.teacherInfoDao.get(no);
            if(teacherInfo!=null){
                if(pwd.equals(teacherInfo.getPassword())){
                    return true;
                }
                else
                    return false;
            }
            else
                return false;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public List<TeacherInfo> getAllTeacherInfos(){
        return this.teacherInfoDao.getAllTecherInfos();
    }

    public TeacherInfo getByNo(String no){
        return this.teacherInfoDao.get(no);
    }

    public void add(TeacherInfo teacherInfo){
        this.teacherInfoDao.add(teacherInfo);
    }

    public void update(TeacherInfo teacherInfo){
        this.teacherInfoDao.update(teacherInfo);
    }

    public void delete(String no){
        this.teacherInfoDao.delete(no);
    }
}
