package com.umc.week5.mission.service;

import com.umc.week5.mission.Mission;
import com.umc.week5.enums.MissionStatus;

import java.util.List;

public interface MissionQueryService {

    List<Mission> findall();
    List<Mission> findMissionsByMemberMissionStatus(MissionStatus status);
}
