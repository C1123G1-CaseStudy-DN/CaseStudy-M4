package com.example.blog.service.blog;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IBlogService {
    List<Blog> findBlog();

    void createBl(Blog blog);

    void editBl(Blog blog);

    Blog findById(Integer id);

    void re(Integer id);

    Page<Blog> getBlogs(int page, int size);
}
