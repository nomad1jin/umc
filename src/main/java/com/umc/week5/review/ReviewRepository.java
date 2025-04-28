package com.umc.week5.review;

import com.umc.week5.Entity.Review;
import com.umc.week5.Entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {
}
