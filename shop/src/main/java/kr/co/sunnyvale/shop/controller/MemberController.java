package kr.co.sunnyvale.shop.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import kr.co.sunnyvale.shop.domain.Member;
import kr.co.sunnyvale.shop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/login")
    public String login(){
        return "/members/login";
    }

    @GetMapping("/join")
    public String joinform() {
        return "/members/join";
    }

    @PostMapping("/join")
    public String join(@RequestParam(name = "id")String email, @RequestParam(name = "password")String password, @RequestParam(name = "name")String name, ModelMap modelMap){
        if(!StringUtils.hasText(email) || !StringUtils.hasText(password) || !StringUtils.hasText(name)){
            modelMap.addAttribute("message", "정보를 정확히 입력하세요");
            return "/members/join";
        }
        Member member = memberService.getMember(email);
        if(member != null){
            modelMap.addAttribute("message", "같은 이메일이 이미 등록되어 있습니다.");
            return "/members/join";
        }
        memberService.addMember(name, email, password);
        return "redirect:/members/login";
    }
}
