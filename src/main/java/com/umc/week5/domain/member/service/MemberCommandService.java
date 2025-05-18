package com.umc.week5.domain.member.service;

import com.umc.week5.domain.member.dto.MemberRequestDTO;
import com.umc.week5.domain.member.entity.Member;

public interface MemberCommandService {

    public Member joinMember(MemberRequestDTO.JoinDto request);

}
