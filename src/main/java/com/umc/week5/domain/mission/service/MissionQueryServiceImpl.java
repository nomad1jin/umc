package com.umc.week5.domain.mission.service;


import com.umc.week5.domain.Entity.Store;
import com.umc.week5.domain.member.entity.Member;
import com.umc.week5.domain.member.repository.MemberRepository;
import com.umc.week5.domain.mission.entity.Mission;
import com.umc.week5.domain.enums.MissionStatus;
import com.umc.week5.domain.mission.repo.MissionRepository;
import com.umc.week5.domain.review.entity.Review;
import com.umc.week5.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;


    @Override
    public List<Mission> findall() {
        return missionRepository.findAll();
    }

    @Override
    public List<Mission> findMissionsByMemberMissionStatus(MissionStatus status) {
        return missionRepository.findMissionsByMemberMissionStatus(status);
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page){
        /// 일단 가게를 뽑아내서 가게에 해당하는 미션들을 뽑기
        Store store = storeRepository.findById(storeId).get();
        Page<Mission> MissionPage = missionRepository.findAllByStore(store, PageRequest.of(page, 5));
        return MissionPage;
    }

    @Override
    public Page<Mission> getMyMissionList(Long userId, Integer page) {
        Page<Mission> MissionPage = missionRepository.findAllMissionByMember_Id(userId, PageRequest.of(page, 5));

        return MissionPage;
    }
}

