package examples.boot.springboard.repository;

import examples.boot.springboard.domain.Guestbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/*
JpaRepository : 엔티티를 저장, id에해당하는 것을 조회, 모든 것을 조회, 삭제
* 해당 인터페이스를 구현하는 클래스는 작성하지 않는다.
* 실행시에 자동으로 객체가 생성되고 해당 객체 Bean으로 관리가 된다.
 */
public interface GuestbookRepository
        extends JpaRepository<Guestbook,Long> {
    // Spring Data JPA - Query Method
    public Page<Guestbook> findAllByOrderByIdDesc(Pageable pageable);

}
