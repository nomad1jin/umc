package com.umc.week5.domain.member.controller;

import com.umc.week5.global.apiPayload.ApiResponse;
import com.umc.week5.domain.member.converter.MemberConverter;
import com.umc.week5.domain.member.dto.MemberRequestDTO;
import com.umc.week5.domain.member.dto.MemberResponseDTO;
import com.umc.week5.domain.member.entity.Member;
import com.umc.week5.domain.member.service.MemberCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
