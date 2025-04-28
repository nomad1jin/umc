package com.umc.week5.mission;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umc.week5.Entity.Mission;
import com.umc.week5.Entity.QMission;
import com.umc.week5.Entity.QRegion;
import com.umc.week5.Entity.QStore;
import com.umc.week5.enums.MissionStatus;
import com.umc.week5.mapping.QMemberMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.umc.week5.Entity.QMission.mission;
import static com.umc.week5.Entity.QRegion.region;
import static com.umc.week5.Entity.QStore.store;

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
