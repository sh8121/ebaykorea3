package examples.boot.springboard.domain;

import javax.persistence.*;

@Entity
@Table(name = "reply")
public class Reply {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
}
