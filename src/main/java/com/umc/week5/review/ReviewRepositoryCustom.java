package com.umc.week5.review;

import com.umc.week5.Entity.Review;
import com.umc.week5.Entity.Store;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<Review> findReviewsByStoreId(Long storeId);
}
