package kr.co.sunnyvale.shop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "member")
@Setter
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 255, nullable = false)
    private String email;
    @Column(length = 255, nullable = false)
    private String password;
    private LocalDateTime regdate;
    @ManyToMany
    @JoinTable(name = "member_role",
            joinColumns =
            @JoinColumn(name = "member_id",
                    referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "role_id",
                    referencedColumnName = "id"))
    private Set<Role> roles;
}
