package examples.boot.springboard.domain;

import javax.persistence.*;

@Entity
@Table(name = "upload_file")
public class UploadFile {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
}
