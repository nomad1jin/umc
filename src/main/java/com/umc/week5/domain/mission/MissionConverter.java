package com.umc.week5.domain.mission;

import com.umc.week5.domain.mission.dto.MissionResponseDto;
import com.umc.week5.domain.mission.entity.Mission;
import com.umc.week5.domain.review.dto.ReviewResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    public static MissionResponseDto.MissionPreViewDTO toMissionDto(Mission mission) {
        return MissionResponseDto.MissionPreViewDTO.builder()
                .missionId(mission.getId())
                .title(mission.getTitle())
                .reward(mission.getReward())
                .storeName(mission.getStore().getName())
                .startDate(mission.getStartDate())
                .endDate(mission.getEndDate())
                .build();
    }

    public static MissionResponseDto.MissionPreViewListDTO toMissionListDto(Page<Mission> missionList){

        List<MissionResponseDto.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MissionConverter::toMissionDto)
                .collect(Collectors.toList());

        return MissionResponseDto.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .build();
    }
}
