package cn.yoouu.mapper;

import cn.yoouu.pojo.Student;
import cn.yoouu.pojo.Teacher;

import java.util.List;

public interface StudentMapper {
    // 获取所有学生
    List<Student> getStudents();

    /**
     * @获取学生及其老师
     * 多对一
     * @return
     */
    List<Student> getStudentAndTeacher();
}
