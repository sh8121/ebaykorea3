package examples.boot.springboard.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "board")
@Setter @Getter
public class Board {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "board")
    private Set<UploadFile> uploadFiles;

    private String title;

    @OneToOne(mappedBy = "board", cascade = CascadeType.ALL)
    private BoardContent boardContent;

    private int readCount;
    private LocalDateTime createDate;
}
