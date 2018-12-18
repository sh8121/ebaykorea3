package kr.co.sunnyvale.shop.service;

import kr.co.sunnyvale.shop.domain.Member;
import kr.co.sunnyvale.shop.domain.Role;
import kr.co.sunnyvale.shop.repository.MemberRepository;
import kr.co.sunnyvale.shop.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;

    @Transactional(readOnly = true)
    public Member getMember(String email){
        return memberRepository.getMember(email);
    }

    @Transactional
    public Member addMember(String name, String email, String password){
        Member member = new Member();
        member.setEmail(email);
        member.setName(name);
        member.setRegdate(LocalDateTime.now());
        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.getOne((long)1);
        roles.add(role);
        member.setRoles(roles);

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        member.setPassword(encodedPassword);
        memberRepository.save(member);
        return member;
    }
}