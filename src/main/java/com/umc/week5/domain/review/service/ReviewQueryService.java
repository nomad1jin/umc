package com.umc.week5.domain.review.service;

import com.umc.week5.domain.review.entity.Review;
import org.springframework.data.domain.Page;


import java.util.List;

public interface ReviewQueryService {

    List<Review> findall();

    Page<Review> getReviewList(Long storeId, Integer page);
}
