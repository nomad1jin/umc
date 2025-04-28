package com.umc.week5.review;


import com.umc.week5.Entity.Review;
import com.umc.week5.Entity.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;


    @Override
    public List<Review> findall() {
        return reviewRepository.findAll();
    }
}
