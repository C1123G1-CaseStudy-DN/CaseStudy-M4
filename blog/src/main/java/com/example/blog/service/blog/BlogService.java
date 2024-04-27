package com.example.blog.service.blog;

import com.example.blog.model.Blog;
import com.example.blog.repository.blog.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository iBlogRepository;
    @Override
    public List<Blog> findBlog() {
        return iBlogRepository.findAll();
    }

    @Override
    public void createBl(Blog blog) {
        iBlogRepository.save(blog);
    }
}
