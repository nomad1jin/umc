package com.umc.week5.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import jakarta.validation.constraints.*;

@Getter
@AllArgsConstructor
public class ReviewRequestDto {
    @NotBlank
    private String title;

    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("5.0")
    private Float score;
}

