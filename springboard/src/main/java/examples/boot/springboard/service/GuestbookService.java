package examples.boot.springboard.service;

import examples.boot.springboard.domain.Guestbook;
import org.springframework.data.domain.Page;

/*
비지니스 메소드를 가지는 서비스 interface를 만든다.
 */
public interface GuestbookService {
    public Guestbook addGuestbook(Guestbook guestbook);
    public Page<Guestbook> getGuestbook(int page);
}
