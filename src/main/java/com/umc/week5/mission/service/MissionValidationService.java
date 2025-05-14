package com.umc.week5.mission.service;

import com.umc.week5.mission.Mission;
import com.umc.week5.mission.repo.MissionRepository;
import com.umc.week5.apiPayload.exception.GeneralException;
import com.umc.week5.apiPayload.code.status.ErrorStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionValidationService {

    private final MissionRepository missionRepository;

    public Mission findById(Long missionId) {
        return missionRepository.findById(missionId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));
    }
}

