package com.umc.week5.domain.mission.repo;

import com.umc.week5.domain.Entity.Store;
import com.umc.week5.domain.mission.entity.Mission;
import com.umc.week5.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
    boolean existsByIdAndMember_Id(Long id, Long memberId);
    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);

    Page<Mission> findAllMissionByMember_Id(Long memberId, PageRequest pageRequest);
}
