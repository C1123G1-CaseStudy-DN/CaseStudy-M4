package com.example.blog.controller.user;


import com.example.blog.model.User;
import com.example.blog.service.roles.IRolesService;
import com.example.blog.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController  {
    @Autowired
    private IUserService userService;
    @Autowired
    private IRolesService rolesService;

    @GetMapping("")
    public String showListUser(Model model) {
        List<User> userList = userService.getAllBlog();
        model.addAttribute("userList", userList);
        return "list";
    }
    @GetMapping("/create")
    public String showCreateUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("rolesList", rolesService.getAll());
        return "create";
    }
    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user ){
        userService.saveUser(user);
        return "redirect:/user";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return "redirect:/user";
    }
    @GetMapping("/edit/{id}")
    public String showEditUser(@PathVariable("id") Integer id , Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user" , user);
        model.addAttribute("rolesList",rolesService.getAll());
        return "edit";
    }
    @PostMapping("/edit")
    public  String editUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/user";
    }
    @GetMapping("/detail/{id}")
    public String showUser(@PathVariable("id") Integer id , Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "user";
    }
}
