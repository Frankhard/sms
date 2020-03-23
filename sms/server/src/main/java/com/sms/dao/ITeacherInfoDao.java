package com.sms.dao;

import com.sms.model.ResponseModel;
import com.sms.model.TeacherInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ITeacherInfoDao {

    @Select("select * from TeacherInfo")
    public List<TeacherInfo> getAllTecherInfos();

    @Select("select * from TeacherInfo where No=#{no}")
    public TeacherInfo get(String no);

    @Insert("insert into TeacherInfo(No,Name,Password,age) values(#{no},#{name},#{password},#{age})")
    public void add(TeacherInfo teacherInfo);

    @Delete("delete from TeacherInfo where no=#{no}")
    public void delete(String no);

    @Update("update TeacherInfo set Name=#{name},Password=#{password},Age=#{age} where No=#{no}")
    public void update(TeacherInfo teacherInfo);
}
