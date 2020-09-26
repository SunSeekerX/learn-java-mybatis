package cn.yoouu.mapper;

import cn.yoouu.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    // 添加blog
    int addBlog(Blog blog);

    // 查询博客
    List<Blog> getBlogIf(Map map);
}
