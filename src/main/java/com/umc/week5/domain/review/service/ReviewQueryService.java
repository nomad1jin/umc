package com.umc.week5.domain.review.service;

import com.umc.week5.domain.review.entity.Review;

import java.util.List;

public interface ReviewQueryService {

    List<Review> findall();
}
