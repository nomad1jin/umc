package com.umc.week5.member.service;

import com.umc.week5.member.dto.MemberRequestDTO;
import com.umc.week5.member.entity.Member;

public interface MemberCommandService {

    public Member joinMember(MemberRequestDTO.JoinDto request);

}
