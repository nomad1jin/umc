package com.umc.week5.mission.repo;

import com.umc.week5.mission.Mission;
import com.umc.week5.enums.MissionStatus;

import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> findMissionsByMemberMissionStatus(MissionStatus status);
}
