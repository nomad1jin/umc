package com.umc.week5.domain.mission.service;

import com.umc.week5.domain.mission.entity.Mission;
import com.umc.week5.domain.enums.MissionStatus;

import java.util.List;

public interface MissionQueryService {

    List<Mission> findall();
    List<Mission> findMissionsByMemberMissionStatus(MissionStatus status);
}
