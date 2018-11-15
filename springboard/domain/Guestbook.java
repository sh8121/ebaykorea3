package examples.boot.springboard.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
/*
    Guestbook guestbook = new Guestbook();

    JPA - EntityManager를 직접 개발자가 사용한다.
    영속성관리자.영속성부여(guestbook);

    Spring Data JPA - JpaRepository를 상속하는 인터페이스를 만들면 됩니다.
 */
@Entity // 영속성 객체.
@Table(name="guestbook")
@Setter
@Getter
public class Guestbook {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    String name;

    String content;

    Date regate;
}
