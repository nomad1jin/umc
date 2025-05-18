package com.umc.week5.domain.food;

import com.umc.week5.global.apiPayload.code.status.ErrorStatus;
import com.umc.week5.global.valid.ExistCategories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidater implements ConstraintValidator<ExistCategories, List<Long>> {

    private final FoodCategoryService foodCategoryService;

    @Override
    public void initialize(ExistCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = foodCategoryService.allCategoriesExist(values);
        
        if (!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
