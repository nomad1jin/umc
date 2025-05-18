package com.umc.week5.domain.mission.service;

import com.umc.week5.domain.member.service.MemberValidationService;
import com.umc.week5.global.valid.MissionNotAlreadyChallenged;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class MissionNotAlreadyChallengedValidator implements ConstraintValidator<MissionNotAlreadyChallenged, Long> {

    private final MissionValidationService missionValidationService;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        Long hardcodedMemberId = 1L;
        return !missionValidationService.isAlreadyChallenged(missionId, hardcodedMemberId);
    }
}
