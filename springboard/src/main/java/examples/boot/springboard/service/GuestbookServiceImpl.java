package examples.boot.springboard.service;

import examples.boot.springboard.domain.Guestbook;
import examples.boot.springboard.repository.GuestbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GuestbookServiceImpl implements GuestbookService{
    // 사용할 Repository를 field로 선언한다.
//    @Autowired
    private GuestbookRepository guestbookRepository;
    // 생성자 주입이 일어난다.
    public GuestbookServiceImpl(
            GuestbookRepository guestbookRepository){
        this.guestbookRepository = guestbookRepository;
    }

    @Override
    @Transactional
    public Guestbook addGuestbook(Guestbook guestbook) {
         return guestbookRepository.save(guestbook);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Guestbook> getGuestbook(int page) {
        // page가 0이면 0번째부터 5건을 보여준다.
        // page가 1이면 5번째부터 5건을 보여준다.
        // org.springframework.data.domain.Pageable
        Pageable pageable = PageRequest.of(page, 5);
        return guestbookRepository.findAllByOrderByIdDesc(pageable);
    }
}
