package com.umc.week5.review.controller;

import com.umc.week5.review.dto.ReviewRequestDto;
import com.umc.week5.review.service.ReviewCommandService;
import com.umc.week5.valid.StoreExists;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class ReviewController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/{storeId}/reviews")
    public ResponseEntity<String> addReview(
            @PathVariable @StoreExists Long storeId,
            @RequestBody @Valid ReviewRequestDto requestDto) {
        reviewCommandService.addReview(storeId, requestDto);
        return ResponseEntity.ok("리뷰 등록 성공");
    }
}