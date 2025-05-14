package com.umc.week5.review.repo;

import com.umc.week5.review.entity.Review;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<Review> findReviewsByStoreId(Long storeId);
}
