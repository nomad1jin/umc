package com.umc.week5.domain.mission.controller;

import com.umc.week5.domain.mission.MissionConverter;
import com.umc.week5.domain.mission.dto.MissionRequestDto;
import com.umc.week5.domain.mission.dto.MissionResponseDto;
import com.umc.week5.domain.mission.entity.Mission;
import com.umc.week5.domain.mission.service.MissionCommandService;
import com.umc.week5.domain.mission.service.MissionQueryService;
import com.umc.week5.domain.review.ReviewConverter;
import com.umc.week5.domain.review.dto.ReviewResponseDto;
import com.umc.week5.domain.review.entity.Review;
import com.umc.week5.global.apiPayload.ApiResponse;
import com.umc.week5.global.valid.MissionNotAlreadyChallenged;
import com.umc.week5.global.valid.StoreExists;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    @PostMapping("/challenge")
    public ApiResponse<MissionResponseDto.CreateResultDto> challengeMission(
             @MissionNotAlreadyChallenged MissionRequestDto.CreateMissionDto dto) {
        Mission mission = missionCommandService.challengeMission(dto);
        return ApiResponse.onSuccess(missionCommandService.toMission(mission));
    }

    /// ///조회
    @Operation(summary = "특정 가게의 미션 목록 조회 API",description = "특정 가게의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    /// /아래를 수정하라
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),})
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")})
    @GetMapping("/{storeId}")
    public ApiResponse<MissionResponseDto.MissionPreViewListDTO> getMissionList(
            @PathVariable(name = "storeId") Long storeId,
            @RequestParam(name = "page") Integer page) {
        log.info("요청 도착: storeId={}, page={}", storeId, page);
        Page<Mission> missionList = missionQueryService.getMissionList(storeId, page);
        return ApiResponse.onSuccess(MissionConverter.toMissionListDto(missionList));
    }
}

