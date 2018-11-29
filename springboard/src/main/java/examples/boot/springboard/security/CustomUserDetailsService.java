package examples.boot.springboard.security;

import examples.boot.springboard.domain.Member;
import examples.boot.springboard.domain.Role;
import examples.boot.springboard.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Component
public class CustomUserDetailsService
        implements UserDetailsService {
    @Autowired
    MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member =
                memberRepository.getMemberAndRolesByEmail(email);
        if(member == null)
            throw new UsernameNotFoundException("user not found!");

        Set<GrantedAuthority> authorities =
                new HashSet<>();
        for(Role role : member.getRoles()){
            authorities.add(
            new SimpleGrantedAuthority("ROLE_" +
                    role.getName()));
        }

        LoginUser loginUser
                = new LoginUser(email,
                member.getPassword(),authorities);
        loginUser.setName(member.getName());
        return loginUser;
    }
}
