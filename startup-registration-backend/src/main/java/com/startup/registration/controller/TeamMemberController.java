
package com.startup.registration.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.startup.registration.dto.request.TeamMembersRequest;
import com.startup.registration.service.TeamMemberService;

@RestController
@RequestMapping("/api/team-members")
@CrossOrigin(origins = "http://localhost:5173")
public class TeamMemberController {

    private final TeamMemberService teamMemberService;

    public TeamMemberController(TeamMemberService teamMemberService) {
        this.teamMemberService = teamMemberService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveTeamMembers(
            @RequestBody TeamMembersRequest request) {

        teamMemberService.saveTeamMembers(request);

        return ResponseEntity.ok("Team members saved successfully");
    }
}
