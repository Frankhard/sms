package com.sms.dao;

import com.sms.model.StudentInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface IStudentInfoDao {

    @Select("select * from StudentInfo")
    public List<StudentInfo> getAllStudentInfos();

    @Select("select * from StudentInfo where No = #{no}")
    public StudentInfo getStudentInfoByNo(String No);

    @Select("select * from StudentInfo where Name like '%#{name}%'")
    public List<StudentInfo> getStudentInfoByName(String name);

    @Insert("insert into StudentInfo(Name,No,Password,Moblie,Email,Age,Address,Sex,ClassId,CreateUserId,CreateTime,Status) values(#{name},#{no},#{password},#{moblie},#{email},#{age},#{address},#{sex},#{classId},#{createUserId},#{createTime},#{status})")
    public void addStudentInfo(StudentInfo studentInfo);

    @Update("UPDATE StudentInfo SET Name=#{name},Password=#{password},Moblie=#{moblie},Email=#{email},Age=#{age},Address=#{address},ClassId=#{classId},ModifyTime=#{modifyTime},Status=#{status} WHERE Id = #{id}")
    public void update(StudentInfo studentInfo);

    @Delete("delete from StudentInfo where Id = #{id}")
    public void delete(long id);

}
