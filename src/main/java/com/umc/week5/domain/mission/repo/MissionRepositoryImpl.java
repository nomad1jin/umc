package com.umc.week5.domain.mission.repo;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umc.week5.domain.Entity.QRegion;
import com.umc.week5.domain.Entity.QStore;
import com.umc.week5.domain.mapping.QMemberMission;
import com.umc.week5.domain.mission.entity.Mission;
import com.umc.week5.domain.enums.MissionStatus;
import com.umc.week5.domain.mission.entity.QMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    QMission mission = QMission.mission;
    QMemberMission memberMission = QMemberMission.memberMission;
    QStore store = QStore.store;
    QRegion region = QRegion.region;

    @Override
    public List<Mission> findMissionsByMemberMissionStatus(MissionStatus status) {
        return jpaQueryFactory
                .selectDistinct(mission)
                .from(memberMission)
                .join(memberMission.mission, mission)
                .join(mission.store, store).fetchJoin()
                .join(store.region, region).fetchJoin()
                .where(memberMission.status.eq(status))
                .fetch();
    }
}
