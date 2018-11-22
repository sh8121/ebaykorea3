package examples.boot.springboard.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "member")
@Setter @Getter
public class Member {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    private String name;
    private String email;
    private String password;
    private LocalDateTime regdate;
    @ManyToMany
    @JoinTable(name = "member_role",
            joinColumns =
                @JoinColumn(name = "member_id",
                    referencedColumnName = "id") ,
            inverseJoinColumns =
                @JoinColumn(name = "role_id",
                    referencedColumnName = "id") )
    private Set<Role> roles;
}
