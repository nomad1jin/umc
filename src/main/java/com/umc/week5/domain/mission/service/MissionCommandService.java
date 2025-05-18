package com.umc.week5.domain.mission.service;

import com.umc.week5.domain.Entity.Store;
import com.umc.week5.domain.mission.dto.MissionRequestDto;
import com.umc.week5.domain.mission.dto.MissionResponseDto;
import com.umc.week5.domain.mission.entity.Mission;
import com.umc.week5.domain.store.repository.StoreRepository;
import com.umc.week5.global.apiPayload.code.status.ErrorStatus;
import com.umc.week5.global.apiPayload.exception.GeneralException;
import com.umc.week5.domain.member.repository.MemberRepository;
import com.umc.week5.domain.mission.repo.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;


    @Transactional
    public Mission challengeMission(MissionRequestDto.CreateMissionDto dto) {
        Store store = storeRepository.findById(dto.getStoreId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.STORE_NOT_FOUND));

        Mission challenge = Mission.builder()
                .store(store)
                .title(dto.getTitle())
                .description(dto.getDescription())
                .reward(dto.getReward())
                .minSpend(dto.getMinSpend())
                .status("ACTIVE")
                .build();

        //미션 저장
        return missionRepository.save(challenge);
    }

    public MissionResponseDto.CreateResultDto toMission(Mission mission) {
        return MissionResponseDto.CreateResultDto.builder()
                .missionId(mission.getId())
                .title(mission.getTitle())
                .reward(mission.getReward())
                .build();
    }
}
