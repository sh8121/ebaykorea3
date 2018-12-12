package kr.co.sunnyvale.shop.service;

import kr.co.sunnyvale.shop.domain.Member;
import kr.co.sunnyvale.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member getMember(String email){
        return memberRepository.getMember(email);
    }

}