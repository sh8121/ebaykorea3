package examples.boot.springboard.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "member")
@Setter
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegdate() {
        return regdate;
    }

    public void setRegdate(LocalDateTime regdate) {
        this.regdate = regdate;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
