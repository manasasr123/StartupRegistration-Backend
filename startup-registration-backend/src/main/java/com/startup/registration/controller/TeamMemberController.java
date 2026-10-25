
package com.startup.registration.controller;

import org.springframework.http.ResponseEntity;
import java.util.List;
import com.startup.registration.entity.TeamMember;
import com.startup.registration.repository.TeamMemberRepository;
import org.springframework.web.bind.annotation.*;

import com.startup.registration.dto.request.TeamMembersRequest;
import com.startup.registration.service.TeamMemberService;

@RestController
@RequestMapping("/api/team-members")
@CrossOrigin(origins = "http://localhost:5173")
public class TeamMemberController {

    private final TeamMemberService teamMemberService;

    private final TeamMemberRepository teamMemberRepository;

    public TeamMemberController(
            TeamMemberService teamMemberService,
            TeamMemberRepository teamMemberRepository) {
        this.teamMemberService = teamMemberService;
        this.teamMemberRepository = teamMemberRepository;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveTeamMembers(
            @RequestBody TeamMembersRequest request) {

        teamMemberService.saveTeamMembers(request);

        return ResponseEntity.ok("Team members saved successfully");
    }
    
    @GetMapping("/founder")
    public ResponseEntity<List<TeamMember>> getTeamMembers(
            @RequestParam Long founderId) {

        return ResponseEntity.ok(
                teamMemberRepository.findByFounderId(founderId));
    }
}
