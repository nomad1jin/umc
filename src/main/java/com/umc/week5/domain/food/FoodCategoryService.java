package com.umc.week5.domain.food;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCategoryService {

    private final FoodCategoryRepository foodCategoryRepository;

    public boolean allCategoriesExist(List<Long> categoryIds) {
        return categoryIds.stream()
                .allMatch(foodCategoryRepository::existsById);
    }
}
