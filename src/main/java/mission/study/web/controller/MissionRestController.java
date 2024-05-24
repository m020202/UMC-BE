package mission.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mission.study.apiPayload.ApiResponse;
import mission.study.converter.MissionConverter;
import mission.study.domain.Mission;
import mission.study.service.MissionService.MissionCommandService;
import mission.study.web.dto.MissionRequestDTO;
import mission.study.web.dto.MissionResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionRestController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.JoinResultDTO> join(@RequestBody @Valid MissionRequestDTO.JoinMissionDTO request) {
        Mission mission = missionCommandService.joinMission(request);
        return ApiResponse.onSuccess(MissionConverter.toJoinResultDTO(mission));
    }
}