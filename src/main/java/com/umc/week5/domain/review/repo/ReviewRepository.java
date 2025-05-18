package com.umc.week5.domain.review.repo;

import com.umc.week5.domain.Entity.Store;
import com.umc.week5.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {

    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
}
