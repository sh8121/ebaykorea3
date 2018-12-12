package kr.co.sunnyvale.shop.repository;

import kr.co.sunnyvale.shop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query(value = "select m from Member m join fetch  m.roles where m.id = :userId")
    public Member getMember(@Param("userId")Long userId);

    @Query(value = "select m from Member m join fetch  m.roles where m.email = :email")
    public Member getMember(@Param("email")String email);
}
