package examples.helloboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/boards")
public class BoardController {
    @GetMapping
    public String list(){
        return "list";
    }

    @GetMapping(value = "/write")
    public String write(){
        return "write";
    }
}
