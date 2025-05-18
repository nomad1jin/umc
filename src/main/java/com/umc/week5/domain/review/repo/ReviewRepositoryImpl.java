package com.umc.week5.domain.review.repo;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umc.week5.domain.Entity.QRegion;
import com.umc.week5.domain.Entity.QStore;
import com.umc.week5.domain.review.entity.QReview;
import com.umc.week5.domain.review.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.umc.week5.domain.review.entity.QReview.review;


@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Review> findReviewsByStoreId(Long storeId) {
        QReview qReview = review;
        QStore store = QStore.store;
        QRegion region = QRegion.region;

        return jpaQueryFactory
                .selectFrom(qReview)
                .join(review.store, store).fetchJoin()
                .join(store.region, region).fetchJoin()
                .where(review.store.id.eq(storeId))
                .fetch();
    }

}
