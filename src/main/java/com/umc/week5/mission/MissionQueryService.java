package com.umc.week5.mission;

import com.umc.week5.Entity.Mission;
import com.umc.week5.Entity.Review;
import com.umc.week5.enums.MissionStatus;

import java.util.List;

public interface MissionQueryService {

    List<Mission> findall();
    List<Mission> findMissionsByMemberMissionStatus(MissionStatus status);
}
