package com.umc.week5.review;

import com.umc.week5.Entity.Store;
import com.umc.week5.member.entity.Member;
import com.umc.week5.review.dto.ReviewRequestDto;
import com.umc.week5.review.entity.Review;

public class ReviewConverter {
    public static Review toEntity(ReviewRequestDto dto, Store store, Member member) {
        return Review.builder()
                .title(dto.getTitle())
                .score(dto.getScore())
                .store(store)
                .member(member)
                .build();
    }
}

