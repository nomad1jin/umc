package com.umc.week5.member.service;

import com.umc.week5.apiPayload.code.status.ErrorStatus;
import com.umc.week5.apiPayload.exception.GeneralException;
import com.umc.week5.member.entity.Member;
import com.umc.week5.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberValidationService {


    private final MemberRepository memberRepository;

    public Member getHardcodedMember() {
        return memberRepository.findById(1L)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));
    }
}
