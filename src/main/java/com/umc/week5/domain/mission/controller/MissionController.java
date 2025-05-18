package com.umc.week5.domain.mission.controller;

import com.umc.week5.domain.mission.dto.MissionRequestDto;
import com.umc.week5.domain.mission.dto.MissionResponseDto;
import com.umc.week5.domain.mission.entity.Mission;
import com.umc.week5.domain.mission.service.MissionCommandService;
import com.umc.week5.global.apiPayload.ApiResponse;
import com.umc.week5.global.valid.MissionNotAlreadyChallenged;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/challenge")
    public ApiResponse<MissionResponseDto.CreateResultDto> challengeMission(
             @MissionNotAlreadyChallenged MissionRequestDto.CreateMissionDto dto) {
        Mission mission = missionCommandService.challengeMission(dto);
        return ApiResponse.onSuccess(missionCommandService.toMission(mission));
    }
}

