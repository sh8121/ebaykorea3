package examples.boot.springboard.repository;

import examples.boot.springboard.domain.Member;
import examples.boot.springboard.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Set;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class MemberRepositoryTest {


    @Autowired
    EntityManager entityManager;

    @Test
    public void testEntityManager(){
        Member member = entityManager.find(Member.class, 1L);
        System.out.println(member.getClass().getName());
        System.out.println(member.getName());
        Set<Role> roles = member.getRoles();
        System.out.println(roles.getClass().getName());
        for(Role role : roles){
            System.out.println(role.getName());
        }
    }

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void getMember() throws Exception{
        Member member = memberRepository.getMemberByEmail("urstory@gmail.com");
        System.out.println(member.getClass().getName());
        Set<Role> roles = member.getRoles();
        System.out.println(roles.getClass().getName());
        for(Role role : roles){
            System.out.println(role.getName());
        }
    }
}
