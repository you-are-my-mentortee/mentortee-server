package com.mentortee.user.service;

import com.mentortee.user.domain.Member;
import com.mentortee.user.dto.NickNameDto;
import com.mentortee.user.repository.MemberRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public String save(NickNameDto nickNameDto){
        Member member = memberRepository.save(Member.builder().nickName(nickNameDto.getNickName()).build());
        return member.getNickName();
    }
}
