package com.sms.api;

import com.sms.model.ResponseModel;
import com.sms.model.StudentInfo;
import com.sms.service.StudentInfoService;
import com.sms.service.TokenService;
import com.sms.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/stu")
public class StudentInfoController {

    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/list")
    public List<StudentInfo> list(){
        return this.studentInfoService.getStudentInfos();
    }

    @RequestMapping("/searchByName")
    public List<StudentInfo> searchByName(String name){
        return this.studentInfoService.getStudentInfoByName(name);
    }

    @RequestMapping("/add")
    public ResponseModel add(StudentInfo studentInfo){
        try {
            this.studentInfoService.addStudentInfo(studentInfo);
            return new ResponseModel(true,"200");
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseModel(false,ex.getMessage());
        }

    }

    @RequestMapping("/delete")
    public ResponseModel ResponseModel(long id){
        try {
            this.studentInfoService.deleteStudentInfo(id);
            return new ResponseModel(true,"200");
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseModel(false,ex.getMessage());
        }
    }

    @RequestMapping("/update")
    public ResponseModel update(StudentInfo studentInfo){
        try {
            this.studentInfoService.updateStudentInfo(studentInfo);
            return new ResponseModel(true,"200");
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseModel(false,ex.getMessage());
        }
    }

    @RequestMapping("/login.do")
    public ResponseModel cheakPassword(String no, String pwd, HttpServletRequest request){
        try {
            StudentInfo studentInfo = this.studentInfoService.checkPassword(no,pwd);
            if(studentInfo !=null){
                String userAgent = request.getHeader("user-agent");
                String token = this.tokenService.generateToken(userAgent, no);
                this.tokenService.save(token, no);
                return new ResponseModel(true,"200",token);
            }
            else
                return new ResponseModel(false,"用户名或密码错误");
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseModel(false,ex.getMessage());
        }
    }

    public ResponseModel logout(String token){
        try{
            this.tokenService.delete(token);
            return new ResponseModel(true,"200");
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseModel(false,ex.getMessage());
        }
    }

    @RequestMapping("/checkToken")
    public ResponseModel checkToken(String token){
        try{
            String tok=redisUtil.get(token);
            if(tok !=null){
                return new ResponseModel(true,"200");
            }
            return new ResponseModel(false,"登录过期请重新登录");
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseModel(false,"出现异常请重新登录");
        }
    }
}
