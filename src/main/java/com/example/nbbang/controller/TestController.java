package com.example.nbbang.controller;

import com.example.nbbang.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/test/main")
    public String showMain(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String nickname = ((User) userDetails).getNickname();
            model.addAttribute("nickname", nickname);
        }
        return "room";
    }

    @GetMapping("/test/page")
    public String showMain2(){
        return "schedule";
    }
}
