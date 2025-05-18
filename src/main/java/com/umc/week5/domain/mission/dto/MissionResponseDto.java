package com.umc.week5.domain.mission.dto;

import lombok.Builder;

import java.time.LocalDate;

public class MissionResponseDto {

    @Builder
    public static class CreateResultDto {
        private Long missionId;
        private String title;
        private int reward;
        private LocalDate startDate;
        private LocalDate endDate;
    }
}
