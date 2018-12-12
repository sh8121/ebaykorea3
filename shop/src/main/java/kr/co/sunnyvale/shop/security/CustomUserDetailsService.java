package kr.co.sunnyvale.shop.security;


import kr.co.sunnyvale.shop.domain.Member;
import kr.co.sunnyvale.shop.domain.Role;
import kr.co.sunnyvale.shop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    MemberService memberService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberService.getMember(email);
        if(member == null)
            throw new UsernameNotFoundException(email + " is not found");

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for(Role role : member.getRoles()){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }

        CustomUserDetails userDetails = new CustomUserDetails(email, member.getPassword(), authorities);
        userDetails.setName(member.getName());
        userDetails.setId(member.getId());
        return userDetails;
    }
}