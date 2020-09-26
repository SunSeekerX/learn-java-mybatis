package cn.yoouu.mapper;

import cn.yoouu.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    // 获取所有老师
    List<Teacher> getTeachers();

    // 获取老师及其下面所有学生
    Teacher getTeacher(@Param("tid") int id);
}
