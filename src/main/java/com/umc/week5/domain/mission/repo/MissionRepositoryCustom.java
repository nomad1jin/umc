package com.umc.week5.domain.mission.repo;

import com.umc.week5.domain.mission.entity.Mission;
import com.umc.week5.domain.enums.MissionStatus;

import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> findMissionsByMemberMissionStatus(MissionStatus status);
}
