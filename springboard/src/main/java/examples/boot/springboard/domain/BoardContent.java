package examples.boot.springboard.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "board_content")
@Setter
@Getter
public class BoardContent {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    @OneToOne
    @JoinColumn(name = "board_id")
    private Board board;

}
