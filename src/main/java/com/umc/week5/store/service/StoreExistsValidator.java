package com.umc.week5.store.service;

import com.umc.week5.apiPayload.code.status.ErrorStatus;
import com.umc.week5.food.FoodCategoryService;
import com.umc.week5.valid.ExistCategories;
import com.umc.week5.valid.StoreExists;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StoreExistsValidator implements ConstraintValidator<StoreExists, Long> {

    private final StoreValidationService storeValidationService;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return storeValidationService.existsById(value);
    }
}
