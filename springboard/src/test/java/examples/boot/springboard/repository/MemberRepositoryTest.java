package examples.boot.springboard.repository;

import examples.boot.springboard.domain.Member;
import examples.boot.springboard.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void getMember() throws Exception{
        Member member = memberRepository.getMemberAndRolesByEmail("urstory@gmail.com");
        Set<Role> roles = member.getRoles();
        for(Role role : roles){
            System.out.println(role.getName());
        }
    }
}
