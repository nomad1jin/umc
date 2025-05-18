package com.umc.week5.domain.mission.repo;

import com.umc.week5.domain.mission.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
    boolean existsByIdAndMember_Id(Long id, Long memberId);
}
