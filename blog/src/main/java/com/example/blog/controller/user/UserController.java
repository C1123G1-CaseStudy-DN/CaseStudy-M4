package com.example.blog.controller.user;


import com.example.blog.model.User;
import com.example.blog.service.roles.IRolesService;
import com.example.blog.service.user.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IRolesService rolesService;

    @GetMapping("")
    public String showListUser(@RequestParam(value = "page", defaultValue = "0") int page,
                               @RequestParam(value = "size", defaultValue = "5") int size,
                               Model model) {
        Page<User> userPage = userService.getUsers(page, size);
        model.addAttribute("userPage", userPage);
        return "user/listUser";
    }

    @GetMapping("/create")
    public String showCreateUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("rolesList", rolesService.getAll());
        return "user/createUser";
    }

    @PostMapping("/create")
    public String createUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("rolesList", rolesService.getAll());
            return "user/createUser"; // Trả về trang tạo mới nếu có lỗi
        }
        userService.saveUser(user);
        return "redirect:/user";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String showEditUser(@PathVariable("id") Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("rolesList", rolesService.getAll());
        return "user/updateUser";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/user";
    }

    @GetMapping("/detail/{id}")
    public String showUser(@PathVariable("id") Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user/user";
    }
//    @GetMapping("/search")
//    public String showSearch(@RequestParam("kq") String key, Model model,
//                             @RequestParam(name = "page", defaultValue = "0") int page) {
//        Pageable pageable = PageRequest.of(page, 2);
//        Page<User> userPage = userService.findByName(key,pageable);
//        model.addAttribute("userList", products);
//        return "display";
//    }
}
