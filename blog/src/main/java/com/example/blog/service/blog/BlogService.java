package com.example.blog.service.blog;

import com.example.blog.model.Blog;
import com.example.blog.repository.blog.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableMethodSecurity
@Service
public class BlogService implements IBlogService {
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

    @Override
    public void editBl(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).get();
    }

    @Override
    public void re(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> getBlogs(int page, int size) {
        return iBlogRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Blog> getRandomBlog(int count) {
        List<Blog> allBlogs = iBlogRepository.findAll();
        Collections.shuffle(allBlogs);
         return allBlogs.subList(0,Math.min(count,allBlogs.size()));
    }

}
