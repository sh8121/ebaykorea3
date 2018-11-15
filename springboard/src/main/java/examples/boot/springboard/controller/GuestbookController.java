package examples.boot.springboard.controller;

import examples.boot.springboard.domain.Guestbook;
import examples.boot.springboard.repository.GuestbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/*
Spring Boot에서 Web이라는 것을 사용하면, Tomcat이라는 WAS가 내장되서 실행된다.
spring-boot-starter-web을 사용하면, 자동설정으로 DispatcherServlet
이라는 것이 Bean으로 된다. DispacherServlet은 FrontController라고 말하기도 한다.

웹 클라이언트(ex> 브라우저)의 요청을 받아서 응답하는 것이 DispacherServlet이다.


Spring Boot는 @SpringBootApplication 어노테이션이 붙어있는 클래스의 패키지
아래에서 컴포넌트를 찾아 Bean으로 등록을 한다.

결국 @Controller가 붙은 클래스도 Bean으로 등록이 된다.
컨트롤러가 Bean으로 등록되고 나서, 해당 컨트롤러가 가지고 있는
@RequestMapping(@GetMapping, @PostMapping,
@DeleteMaping, @PutMapping 등)이라는 어노테이션 정보를 읽어들인다.

DispacherServlet은 위의 정보를 들여서 HandlerMapping이라는 객체에
정보를 보관한다.
요청이 오면 HandlerMapping으로 찾아서, HandlerAdapter에게 실행을 부탁한다.
컨트롤러의 메소드가 실행되면 view name이 리턴되는데, view name을 가지고 알맞은
View를 보여주게 된다.

 */
@Controller
public class GuestbookController {
    @Autowired // 의존성 주입.
    GuestbookRepository guestbookRepository;

    @GetMapping("/")
    public String list(){
        return "index";
    }

    @PostMapping("/write")
    public String write(@RequestParam(name = "name") String name,
                   @RequestParam(name="content") String content){
        System.out.println("name : " + name);
        System.out.println("content : " + content);
        return "redirect:/";
    }

}

/*

    Controller ( path에 해당하는 결과를 출력 ) - 프리젠테이션 레이어.

    Service - 비지니스메소드를 가지고 있다. 트랜잭션단위로 동작한다.

    Repository or DAO - 데이터
 */














