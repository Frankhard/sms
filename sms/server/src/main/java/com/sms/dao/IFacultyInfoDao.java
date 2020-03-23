package com.sms.dao;

import com.sms.model.FacultyInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface IFacultyInfoDao {

    @Select("select * from FacultyInfo")
    public List<FacultyInfo> getAllFacultyInfos();

    @Select("select * from FacultyInfo where Id = #{id}")
    public FacultyInfo get(long id);

    @Select("select * from FacultyInfo where Name like '%#{name}%'")
    public List<FacultyInfo> getFacultyInfoByName(String name);

    @Insert("insert into FacultyInfo(Name) values(#{name})")
    public void addFacultyInfo(FacultyInfo facultyInfo);

    @Update("update FacultyInfo set Name=#{name} where Id=#{id}")
    public void update(FacultyInfo facultyInfo);

    @Delete("delete from FacultyInfo where Id=#{id}")
    public void delete(long id);
}
