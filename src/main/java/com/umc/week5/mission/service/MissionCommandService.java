package com.umc.week5.mission.service;

import com.umc.week5.mission.Mission;
import com.umc.week5.apiPayload.code.status.ErrorStatus;
import com.umc.week5.apiPayload.exception.GeneralException;
import com.umc.week5.member.entity.Member;
import com.umc.week5.member.repository.MemberRepository;
import com.umc.week5.mission.repo.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MissionCommandService {

    private final MissionRepository missionRepository;
    private final ChallengeRepository challengeRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void challengeMission(Long missionId) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));

        Member member = memberRepository.findById(1L) // 하드코딩
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        Challenge challenge = Challenge.builder()
                .mission(mission)
                .member(member)
                .build();

        challengeRepository.save(challenge);
    }
}
