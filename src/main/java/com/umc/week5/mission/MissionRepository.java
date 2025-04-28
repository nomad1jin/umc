package com.umc.week5.mission;

import com.umc.week5.Entity.Mission;
import com.umc.week5.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
}
