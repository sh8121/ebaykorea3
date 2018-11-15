package examples.boot.springboard.controller;

import examples.boot.springboard.domain.Guestbook;
import examples.boot.springboard.repository.GuestbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class GuestbookController {
    @Autowired // 의존성 주입.
    GuestbookRepository guestbookRepository;

    @GetMapping("/")
    public String list(){
        Guestbook guestbook1 = new Guestbook();
        guestbook1.setName("kim");
        guestbook1.setContent("hello");
        guestbook1.setRegate(new Date());
        guestbookRepository.save(guestbook1);

        return "index";
    }
}
