package cn.yoouu.mapper;

import cn.yoouu.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 查询全部用户
    List<User> getUserList();

    @Select("select * from user")
    List<User> getUsers();

    // 根据 id 查询用户
    User getUserById(int id);

    // 增加一个用户
    int insertUser(User user);

    // 分页查询
    List<User> getUserLimit(Map<String, Object> map);
}
