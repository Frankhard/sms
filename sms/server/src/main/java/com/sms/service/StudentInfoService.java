package com.sms.service;

import com.sms.dao.IStudentInfoDao;
import com.sms.model.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInfoService {

    @Autowired
    private IStudentInfoDao studentInfoDao;

    public List<StudentInfo> getStudentInfos(){
        return this.studentInfoDao.getAllStudentInfos();
    }

    public List<StudentInfo> getStudentInfoByName(String name){
        return this.studentInfoDao.getStudentInfoByName(name);
    }

    public StudentInfo checkPassword(String no,String pwd){
        try {
            StudentInfo s=this.studentInfoDao.getStudentInfoByNo(no);
            if(s!=null){
                if(pwd.equals(s.getPassword())){
                    return s;
                }
                else
                    return null;
            }
            return null;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public void addStudentInfo(StudentInfo studentInfo){
        this.studentInfoDao.addStudentInfo(studentInfo);
    }

    public void updateStudentInfo(StudentInfo studentInfo){
        this.studentInfoDao.update(studentInfo);
    }

    public void deleteStudentInfo(long id){
        this.studentInfoDao.delete(id);
    }


}
