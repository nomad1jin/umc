package com.umc.week5.review;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umc.week5.Entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.umc.week5.Entity.QRegion.region;
import static com.umc.week5.Entity.QReview.review;
import static com.umc.week5.Entity.QStore.store;

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
