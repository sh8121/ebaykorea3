package kr.co.sunnyvale.shop.service;

import kr.co.sunnyvale.shop.domain.Member;
import kr.co.sunnyvale.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public Member getMember(String email){
        return memberRepository.getMember(email);
    }

}