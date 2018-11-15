package examples.boot.springboard.repository;

import examples.boot.springboard.domain.Guestbook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestbookRepository
        extends JpaRepository<Guestbook, Long> {
}
