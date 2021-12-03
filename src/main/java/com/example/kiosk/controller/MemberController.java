package com.example.kiosk.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.kiosk.dto.UserDto;
import com.example.kiosk.service.MemberService;

@Controller
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;

    // 메인 페이지
    @GetMapping("/")
    public String index() {
        return "/login";
    }

    // 회원가입 페이지
    @GetMapping("/signup")
    public String dispSignup() {
        return "/signup";
    }

    // 회원가입 처리
    @PostMapping("/signup")
    public String execSignup(UserDto userDto) {
        memberService.joinUser(userDto);

        return "redirect:/";
    }

    // 접근 거부 페이지
    @GetMapping("/user/denied")
    public String dispDenied() {
        return "/denied";
    }

    // 내 정보 페이지
    @GetMapping("/admin")
    public String dispMyInfo() {
        return "/myinfo";
    }
}
