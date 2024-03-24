package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    @Delete("delete from emp where id = #{id}")
    public void deleteById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insertEmp(Emp emp);

    @Update("update emp set username = #{username}, name = #{name}, gender = #{gender}, image = #{image}, " +
            "job = #{job}, entrydate = #{entrydate}, dept_id = #{deptId}, update_time = #{updateTime} where id = #{id}")
    public void updateEmp(Emp emp);

    //实体类属性名和数据库表查询返回的字段名一致，mybatis会自动封装
    //如果实体类属性名和数据库表查询返回的字段名不一致，不能自动封装

    //方案一（推荐）：开启mybatis的驼峰命名自动映射开关(在application.properties文件中配置)---dept_id -----> deptId
    @Select("select * from emp where id = #{id}")
    public Emp selectById(Integer id);

    //方案二：给字段起别名，让别名与实体类属性一致
    /*@Select("select id, username, password, name, gender, image, job, entrydate," +
            "dept_id deptId, create_time createTime, update_time updateTime from emp where id = #{id}")
    public Emp selectById(Integer id);*/

    //方案三：通过@Results,@Result注解手动映射封装
   /* @Results({
            @Result(property = "deptId", column = "dept_id"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    @Select("select * from emp where id = #{id}")
    public Emp selectById(Integer id);*/


    //contact()：mysql提供的字符串拼接函数
//    @Select("select * from emp where name like concat('%', #{name}, '%') and gender = #{gender}" +
//            " and entrydate between #{startDate} and #{endDate} order by update_time desc")
//    public List<Emp> list(String name, Short gender, LocalDate startDate, LocalDate endDate);

    //%${name}%，性能低、不安全、存在SQL注入问题
   /* @Select("select * from emp where name like '%${name}%' and gender = #{gender}" +
            " and entrydate between #{startDate} and #{endDate} order by update_time desc")
    public List<Emp> list(String name, Short gender, LocalDate startDate, LocalDate endDate);*/

    //动态条件查询
    public List<Emp> list(String name, Short gender, LocalDate startDate, LocalDate endDate);

    //动态更新员工
    public void updateEmp2(Emp emp);

    //批量删除员工
    public void deleteByIds(List<Integer> ids);
}