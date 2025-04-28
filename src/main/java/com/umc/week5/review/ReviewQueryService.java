package com.umc.week5.review;

import com.umc.week5.Entity.Review;
import com.umc.week5.Entity.Store;

import java.util.List;
import java.util.Optional;

public interface ReviewQueryService {

    List<Review> findall();
}
