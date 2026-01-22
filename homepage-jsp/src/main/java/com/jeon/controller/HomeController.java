package com.jeon.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class HomeController {

    // 홈(메인 페이지) 보여주기
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("message", "GetMapping으로 더 깔끔해진 홈페이지입니다!");
        return "home";
    }

}
