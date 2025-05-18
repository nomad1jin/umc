package com.umc.week5.domain.mission.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;


@Getter
@AllArgsConstructor
@Builder
public class MissionRequestDto {

    @Getter
    @AllArgsConstructor
    @Builder
    public static class CreateMissionDto{
        @NotNull(message = "가게는 필수입니다")
        private Long storeId;
        private String title;
        private String description;
        @NotNull(message = "보상 포인트는 필수입니다")
        private Integer reward;
        @NotNull(message = "최소 지출 금액은 필수입니다")
        private Integer minSpend;
        private LocalDate startDate;
        private LocalDate endDate;
    }
}
