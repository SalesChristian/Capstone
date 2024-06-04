package org.example.controller;

import org.example.model.User;
import org.example.service.MongoUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private MongoUserDetailsService userService;

    @GetMapping("/user_main.html")
    public String userMain(Model model) {
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        return "user_main";
    }

    @GetMapping("/admin_main.html")
    public String adminMain(Model model) {
        User user = userService.getCurrentUser();
        model.addAttribute("user", user);
        return "admin_main";
    }
    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/user_main")
    public String userMain() {
        return "user_main";
    }

    @GetMapping("/admin_main")
    public String adminMain() {
        return "admin_main";
    }
}
