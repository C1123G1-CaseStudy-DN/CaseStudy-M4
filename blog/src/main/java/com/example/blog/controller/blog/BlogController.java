package com.example.blog.controller.blog;

import com.example.blog.model.Blog;
import com.example.blog.service.blog.IBlogService;
import com.example.blog.service.category.ICategoryService;
import com.example.blog.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;


    @GetMapping("/")
    public String showBlog(Model model) {
        List<Blog> list = iBlogService.findBlog();
        System.out.println(list);
        model.addAttribute("blog", list);
        return "blog";
    }

    @GetMapping
    public String showCreate(Model model) {
        model.addAttribute("category",iCategoryService.finCaatwtegory());
        model.addAttribute("category",iCategoryService.finCaatwtegory());
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute Blog blog) {
        iBlogService.createBl(blog);
        return "redirect:/create/";
    }

    @PostMapping("")
    public String updateBlog(Model model) {

        return "update";
    }

}
