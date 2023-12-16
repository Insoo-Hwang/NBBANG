package com.example.nbbang.controller;

import com.example.nbbang.dto.ArticleDto;
import com.example.nbbang.dto.RoomDto;
import com.example.nbbang.dto.UserDto;
import com.example.nbbang.entity.User;
import com.example.nbbang.service.ArticleService;
import com.example.nbbang.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private ArticleService articleService;

    @GetMapping("/main")
    public String showMain(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String nickname = ((User) userDetails).getNickname();
            Long id = ((User) userDetails).getId();
            List<RoomDto> roomDtos = roomService.getRooms(id);
            model.addAttribute("roomDtos", roomDtos);
            model.addAttribute("nickname", nickname);
        }
        return "main";
    }

    @GetMapping("/room/new")
    public String createRoom(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Long leader = ((User) userDetails).getId();
            model.addAttribute("leader", leader);
        }
        return "new";
    }

    @GetMapping("/room/{id}")
    public String showRoom(@PathVariable Long id, Model model){
        RoomDto dto = roomService.show(id);
        model.addAttribute("dto", dto);
        List<UserDto> userDtos = roomService.getUsers(id);
        model.addAttribute("userDtos", userDtos);
        List<ArticleDto> articleDtos = articleService.articles(id);
        model.addAttribute("articleDtos", articleDtos);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Long userId = ((User) userDetails).getId();
            model.addAttribute("userId", userId);
        }
        return "room";
    }

    @GetMapping("/find")
    public String showPublic(Model model){
        List<RoomDto> publicDtos = roomService.findByShow();
        model.addAttribute("publicDtos", publicDtos);
        return "find";
    }
}
