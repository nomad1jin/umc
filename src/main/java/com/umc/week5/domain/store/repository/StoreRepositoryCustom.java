package com.umc.week5.domain.store.repository;

import com.umc.week5.domain.Entity.Store;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
