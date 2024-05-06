package com.example.blog.controller.blog;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.blog.IBlogService;
import com.example.blog.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.data.domain.Page;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Configuration
@EnableMethodSecurity
@Controller
//@RequestMapping("/blog")

public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;


    @GetMapping("")
    public String showBlog(Model model) {
        List<Blog> randomBlogs = iBlogService.getRandomBlog(6);
        model.addAttribute("blog", randomBlogs);
        return "blog/blog";
    }

    @GetMapping("/list")
    public String showListBlog(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "6") int size,
            Model model
    ) {
        Page<Blog> blogPage = iBlogService.getBlogs(page, size);
        model.addAttribute("blogPage", blogPage); // Thêm phân trang vào model
        return "blog/listBlog"; // Trả về tên của template Thymeleaf
    }


    @GetMapping("/create")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public String showCreate(Model model) {
        model.addAttribute("category", iCategoryService.finCaatwtegory());
        model.addAttribute("blog", new Blog());
        return "blog/createBlog";
    }

    @PostMapping("/create1")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public String createBlog(@ModelAttribute Blog blog) {
        iBlogService.createBl(blog);
        return "redirect:/list";
    }


    @GetMapping("/remove/{id}")
    public String showRemove(@PathVariable Integer id){
        iBlogService.re(id);
        return "redirect:/list";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable("id") Integer id ,Model model) {
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog" , blog);
        model.addAttribute("category" , iCategoryService.finCaatwtegory());
        return "/blog/updateBlog";
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog) {
        iBlogService.editBl(blog);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    public String detailBlog(@PathVariable("id") Integer id,Model model){
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog",blog);
        return "blog/detailblog";
    }
}
