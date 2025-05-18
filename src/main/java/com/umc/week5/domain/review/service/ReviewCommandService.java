package com.umc.week5.domain.review.service;

import com.umc.week5.domain.Entity.Store;
import com.umc.week5.domain.member.entity.Member;
import com.umc.week5.domain.member.service.MemberValidationService;
import com.umc.week5.domain.review.ReviewConverter;
import com.umc.week5.domain.review.dto.ReviewRequestDto;
import com.umc.week5.domain.review.entity.Review;
import com.umc.week5.domain.review.repo.ReviewRepository;
import com.umc.week5.domain.store.service.StoreValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewCommandService {

    private final StoreValidationService storeValidationService;
    private final MemberValidationService memberValidationService;
    private final ReviewRepository reviewRepository;

    @Transactional
    public void addReview(Long storeId, ReviewRequestDto dto) {
        Store store = storeValidationService.findById(storeId);
        Member member = memberValidationService.getHardcodedMember(); // <- 하드코딩 유저

        Review review = ReviewConverter.toEntity(dto, store, member);
        reviewRepository.save(review);
    }
}
