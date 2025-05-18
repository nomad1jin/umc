package com.umc.week5.domain.review;

import com.umc.week5.domain.Entity.Store;
import com.umc.week5.domain.member.entity.Member;
import com.umc.week5.domain.review.dto.ReviewRequestDto;
import com.umc.week5.domain.review.dto.ReviewResponseDto;
import com.umc.week5.domain.review.entity.Review;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;


public class ReviewConverter {
    public static Review toEntity(ReviewRequestDto dto, Store store, Member member) {
        return Review.builder()
                .title(dto.getTitle())
                .score(dto.getScore())
                .store(store)
                .member(member)
                .build();
    }

    public static ReviewResponseDto.ReviewPreViewDTO toReviewDto(Review review) {
        return ReviewResponseDto.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .startDate(review.getStartDate().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static ReviewResponseDto.ReviewPreViewListDTO toReviewListDto(Page<Review> reviewList) {

        List<ReviewResponseDto.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::toReviewDto)  //위에 만든 toReviewDto로 하나씩 반환하는 것
                .collect(Collectors.toList());

        return ReviewResponseDto.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}

