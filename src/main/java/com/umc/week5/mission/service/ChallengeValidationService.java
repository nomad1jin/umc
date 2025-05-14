package com.umc.week5.mission.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChallengeValidationService {

    private final ChallengeRepository challengeRepository;

    public boolean isAlreadyChallenged(Long missionId, Long memberId) {
        return challengeRepository.existsByMissionIdAndMemberId(missionId, memberId);
    }
}
