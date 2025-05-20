package com.umc.week5.domain.mission.service;

import com.umc.week5.domain.mission.entity.Mission;
import com.umc.week5.domain.enums.MissionStatus;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MissionQueryService {

    List<Mission> findall();
    List<Mission> findMissionsByMemberMissionStatus(MissionStatus status);

    Page<Mission> getMissionList(Long storeId, Integer page);
}
