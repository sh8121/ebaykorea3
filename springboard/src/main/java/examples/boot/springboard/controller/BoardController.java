package examples.boot.springboard.controller;

import examples.boot.springboard.security.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/boards")
public class BoardController {

    // /boards/writeform
    @GetMapping("/writeform")
    public String writeform(@AuthUser LoginUser loginUser, Principal principal){
//        System.out.println(principal.getName());
//
//        Authentication authentication =
//                SecurityContextHolder.getContext()
//                        .getAuthentication();
//        LoginUser loginUser =
//                (LoginUser)authentication.getPrincipal();
//        System.out.println(loginUser.getName());
        return "boards/writeform";
    }

    @PostMapping
    public String write(){
        return "redirect:/boards";
    }

    @GetMapping
    public String boards(){
        return "boards/list"; // view name
    }
}

/*
/WEB-INF/jsp/  + viewname + .jsp

spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
 */