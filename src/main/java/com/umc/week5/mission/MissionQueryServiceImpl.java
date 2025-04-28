package com.umc.week5.mission;


import com.umc.week5.Entity.Mission;
import com.umc.week5.enums.MissionStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;


    @Override
    public List<Mission> findall() {
        return missionRepository.findAll();
    }

    @Override
    public List<Mission> findMissionsByMemberMissionStatus(MissionStatus status) {
        return missionRepository.findMissionsByMemberMissionStatus(status);
    }
}
