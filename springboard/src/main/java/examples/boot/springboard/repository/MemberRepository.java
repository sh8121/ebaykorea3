package examples.boot.springboard.repository;

import examples.boot.springboard.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository
        extends JpaRepository<Member, Long> {

    // Spring Data Jpa - Query methods
    // select * from member where email = ?
    //public Member findMemberByEmail(String email);

    // @Query 안에 있는 문자열은 SQL이 아니고 JPQL이라고 한다.
    @Query("select m from Member m where m.email = :email")
    public Member getMemberByEmail(@Param("email") String email);

    @Query("select m from Member m join fetch  m.roles where m.email = :email")
    public Member getMemberAndRolesByEmail(@Param("email") String email);

}

