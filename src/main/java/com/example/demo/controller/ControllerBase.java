package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControllerBase {
    final private UserService userService;

    public ControllerBase(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    String getAllUsersPage(Model s) {
        s.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/{id}")
    String getPage(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user";
    }

    @GetMapping("/new")
    String getAddPage(Model model) {
        model.addAttribute("user",new User());
        return "new";
    }
    @GetMapping("/{id}/edit")
    String getEditPage(@PathVariable Integer id, Model model) {
        model.addAttribute("user",userService.getUser(id));
        return "edit";
    }

    @PostMapping("/")
    String add (@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }
    @PatchMapping("/{id}")
    String edit(@PathVariable Integer id, @ModelAttribute("user") User user){
        userService.update(id,user);
        return "redirect:/";
    }
    @DeleteMapping("/{id}")
    String delete(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
