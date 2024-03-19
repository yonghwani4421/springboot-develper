package me.yonghwan.springbootdeveloper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {
    @GetMapping("/login")
    public String login(){
        return "oathLogin";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }
}
