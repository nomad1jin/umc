package com.umc.week5.Entity;
import com.umc.week5.common.BaseEntity;
import com.umc.week5.mapping.MemberMission;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Float score;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_id")
//    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

//    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
//    private List<ReviewImage> reviewImageList = new ArrayList<>();


    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", score=" + score +
                ", store=" + (store != null ? store.getName() : "null") +
                '}';
    }
}