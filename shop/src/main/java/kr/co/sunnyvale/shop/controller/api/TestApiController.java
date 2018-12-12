package kr.co.sunnyvale.shop.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApiController {
    @GetMapping("/api/test")
    public String test(){
        return "test";
    }
}

// http://localhost:8080/api/test
// http://localhost:8080/h2-console
