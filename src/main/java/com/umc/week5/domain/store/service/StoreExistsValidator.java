package com.umc.week5.domain.store.service;

import com.umc.week5.global.valid.StoreExists;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class StoreExistsValidator implements ConstraintValidator<StoreExists, Long> {

    private final StoreValidationService storeValidationService;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return storeValidationService.existsById(value);
    }
}
