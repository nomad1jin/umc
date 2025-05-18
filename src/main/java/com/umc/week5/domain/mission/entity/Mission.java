package com.umc.week5.domain.mission.entity;

import com.umc.week5.domain.Entity.Store;
import com.umc.week5.domain.member.entity.Member;
import com.umc.week5.global.common.BaseEntity;
import com.umc.week5.domain.mapping.MemberMission;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Integer reward;
    private Integer minSpend;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    @Override
    public String toString() {
        return "Mission{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", reward=" + reward +
                ", minSpend=" + minSpend +
                ", status='" + status + '\'' +
                ", memberMissionList=" + memberMissionList +
                '}';
    }

}
