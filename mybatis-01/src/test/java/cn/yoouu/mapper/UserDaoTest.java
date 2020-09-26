package cn.yoouu.mapper;

import cn.yoouu.pojo.User;
import cn.yoouu.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    @Test
    public void getUserList(){
        // 获得 sqlsession 对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }

        // 关闭 sqlsession
        sqlSession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        System.out.println(user);
        // 关闭 sqlsession
        sqlSession.close();
    }

    @Test
    public void insertUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int resUser = userMapper.insertUser(new User(3, "安琪拉", 123, "峡谷下路"));
        System.out.println(resUser);
        sqlSession.commit();

        // 关闭 sqlsession
        sqlSession.close();
    }

    // 分页测试
    @Test
    public void pagingTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", 2);
        map.put("end", 1);
        List<User> userList = userMapper.getUserLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }

        // 关闭 sqlsession
        sqlSession.close();
    }
}
