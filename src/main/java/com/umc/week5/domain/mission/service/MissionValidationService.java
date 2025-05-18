package com.umc.week5.domain.mission.service;

import com.umc.week5.domain.mission.entity.Mission;
import com.umc.week5.domain.mission.repo.MissionRepository;
import com.umc.week5.global.apiPayload.exception.GeneralException;
import com.umc.week5.global.apiPayload.code.status.ErrorStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionValidationService {

    private final MissionRepository missionRepository;

    public Mission findById(Long Id) {
        return missionRepository.findById(Id)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));
    }

    public boolean isAlreadyChallenged(Long Id, Long memberId) {
        return missionRepository.existsByIdAndMember_Id(Id, memberId);
    }
}

