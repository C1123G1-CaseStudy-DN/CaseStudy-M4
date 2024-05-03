package com.example.blog.controller.blog;

import com.example.blog.model.Blog;
import com.example.blog.service.blog.IBlogService;
import com.example.blog.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;


    @GetMapping("")
    public String showBlog(Model model) {
        List<Blog> list = iBlogService.findBlog();
        System.out.println(list);
        model.addAttribute("blog", list);
        return "blog/blog";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("category", iCategoryService.finCaatwtegory());
        model.addAttribute("blog", new Blog());
        return "blog/createBlog";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute Blog blog) {
        iBlogService.createBl(blog);
        return "redirect:/create/";
    }


    @GetMapping("/remove/{id}")
    public String showRemove(@PathVariable Integer id){
        iBlogService.re(id);
        return "blog/blog";
    }

    @GetMapping("update")
    public String showUpdate(@PathVariable Integer id,Model model) {
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog",blog);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String updateBlog(@ModelAttribute Blog blog) {
        iBlogService.editBl(blog);
        return "blog/updateBlog";
    }

    @GetMapping("/detail/{id}")
    public String detailBlog(@PathVariable("id") Integer id,Model model){
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog",blog);
        return "blog/detailblog";
    }

}
