package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @GetMapping("/admin_main")
    public String adminMain() {
        return "admin_main"; // verweist auf admin_main.html in templates
    }

    @GetMapping("/user_main")
    public String userMain() {
        return "user_main"; // verweist auf user_main.html in templates
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // verweist auf login.html in templates
    }

    @GetMapping("/calendar")
    public String calendar() {
        return "calendar"; // verweist auf calendar.html in templates
    }


}
