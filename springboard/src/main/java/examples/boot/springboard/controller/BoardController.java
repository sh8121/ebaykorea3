package examples.boot.springboard.controller;

import examples.boot.springboard.security.AuthUser;
import examples.boot.springboard.security.LoginUser;
import examples.boot.springboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    // /boards/writeform
    @GetMapping("/writeform")
    public String writeform(@AuthUser LoginUser loginUser,
                            ModelMap map){
        map.addAttribute("name", loginUser.getName());
        // 제목, 내용 입력.
        return "boards/writeform";
    }

    @PostMapping
    public String write(@AuthUser LoginUser loginUser,
        @RequestParam(name = "title")String title,
        @RequestParam(name = "content")String content
    ){
        Assert.hasText(title, "제목을 입력하세요.");
        Assert.hasText(content, "내용을 입력하세요.");
        boardService.addBoard(loginUser.getUserId(),
                title, content);
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