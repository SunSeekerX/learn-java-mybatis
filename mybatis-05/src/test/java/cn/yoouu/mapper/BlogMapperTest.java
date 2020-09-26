package cn.yoouu.mapper;

import cn.yoouu.pojo.Blog;
import cn.yoouu.utils.IDutils;
import cn.yoouu.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BlogMapperTest {
    @Test
    // 添加测试blog
    public void addBlog() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setAuthor("杜甫");

        for (int i = 0; i < 5; i++) {
            blog.setId(IDutils.genUUID());
            blog.setCreateTime(new Date());
            blog.setTitle("标题：" + IDutils.genUUID());
            blog.setViews(-(int) System.currentTimeMillis() % 1000);
            mapper.addBlog(blog);
        }

        sqlSession.close();
    }

    // 查询博客
    @Test
    public void getBlogIf(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap hashMap = new HashMap();
        hashMap.put("author", "李白");

        List<Blog> blogs = mapper.getBlogIf(hashMap);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
}
