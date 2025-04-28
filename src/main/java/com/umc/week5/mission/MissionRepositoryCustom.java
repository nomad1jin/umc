package com.umc.week5.mission;

import com.umc.week5.Entity.Mission;
import com.umc.week5.enums.MissionStatus;

import java.util.List;
import java.util.Optional;

public interface MissionRepositoryCustom {
    List<Mission> findMissionsByMemberMissionStatus(MissionStatus status);
}
