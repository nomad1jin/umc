package com.umc.week5.mission;

import com.umc.week5.mission.service.MissionCommandService;
import com.umc.week5.valid.MissionNotAlreadyChallenged;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/{missionId}/challenge")
    public ResponseEntity<String> challengeMission(
            @PathVariable @MissionNotAlreadyChallenged Long missionId) {
        missionCommandService.challengeMission(missionId);
        return ResponseEntity.ok("미션 도전 성공");
    }
}

