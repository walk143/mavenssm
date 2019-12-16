//package com.sloera.demo.mapper;
//
//import com.sloera.demo.bean.Form;
//import com.sloera.mng.core.ibatis.MapperBaseDao;
//import org.apache.ibatis.annotations.*;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * Created by myzha on 2019/7/3.
// */
//@Repository("demoMapper")
//public interface DemoMapper extends MapperBaseDao<Form> {
//
////    @Select("select * from Form")a
////    public List<Form> getAll();
////
////    @Select("select * from Form where number = #{number}")
////    public Form getByNumber(@Param("number") String number);
//////
//////    @Select("select name from student where id = #{id}")
//////    public String getNameById(long id);
////
////    @Insert("insert into form(apply, file, username, number, password, time, week, city, cars) values(#{form.apply}, #{form.file}, #{form.username}, #{form.number}, #{form.password}, #{form.time}, #{form.week}, #{form.city}, #{form.cars})")
////    public int add(@Param("form") Form form);
////
//////    delete by number
////    @Delete("delete from form where number=#{form.number}")
////    public int delete(@Param("form") Form form);
////    @Delete("delete from form where number=#{number}")
////    public int delete2(@Param("number") String number);
////
//////    update by number
////    @Update("update form set apply=#{form.apply}, file=#{form.file}, username=#{form.username}, number=#{form.number}, password=#{form.password}, time=#{form.time}, week=#{form.week}, city=#{form.city}, cars=#{form.cars} where number=#{form.number}")
////    public int update(@Param("form") Form form);
//
//}
