package com.umc.week5.domain.store.service;

import com.umc.week5.domain.Entity.Store;
import com.umc.week5.global.apiPayload.code.status.ErrorStatus;
import com.umc.week5.global.apiPayload.exception.GeneralException;
import com.umc.week5.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreValidationService {

    private final StoreRepository storeRepository;


    public Store findById(Long storeId) {
        return storeRepository.findById(storeId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.STORE_NOT_FOUND));
    }

    public boolean existsById(Long storeId) {
        return storeRepository.existsById(storeId);
    }
}

