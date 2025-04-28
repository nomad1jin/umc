package com.umc.week5.store.repository;

import com.umc.week5.Entity.Store;
import com.umc.week5.store.repository.StoreRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}
