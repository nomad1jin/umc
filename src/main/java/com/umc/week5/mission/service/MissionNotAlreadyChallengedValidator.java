package com.umc.week5.mission.service;

import com.umc.week5.member.service.MemberValidationService;
import com.umc.week5.valid.MissionNotAlreadyChallenged;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class MissionNotAlreadyChallengedValidator implements ConstraintValidator<MissionNotAlreadyChallenged, Long> {

    private final ChallengeValidationService challengeValidationService;
    private final MemberValidationService memberValidationService;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        Long hardcodedMemberId = 1L;
        return !challengeValidationService.isAlreadyChallenged(missionId, hardcodedMemberId);
    }
}
