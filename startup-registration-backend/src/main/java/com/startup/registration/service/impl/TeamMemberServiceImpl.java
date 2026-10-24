
package com.startup.registration.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.startup.registration.dto.request.TeamMemberRequest;
import com.startup.registration.dto.request.TeamMembersRequest;
import com.startup.registration.entity.Founder;
import com.startup.registration.entity.TeamMember;
import com.startup.registration.repository.FounderRepository;
import com.startup.registration.repository.TeamMemberRepository;
import com.startup.registration.service.TeamMemberService;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {

    private final FounderRepository founderRepository;
    private final TeamMemberRepository teamMemberRepository;

    public TeamMemberServiceImpl(
            FounderRepository founderRepository,
            TeamMemberRepository teamMemberRepository) {
        this.founderRepository = founderRepository;
        this.teamMemberRepository = teamMemberRepository;
    }

    @Override
    @Transactional
    public void saveTeamMembers(TeamMembersRequest request) {

        Founder founder = founderRepository.findById(request.getFounderId())
                .orElseThrow(() ->
                        new RuntimeException("Founder not found"));

        // Replace the previously saved team list for this founder.
        teamMemberRepository.deleteByFounderId(founder.getId());

        List<TeamMemberRequest> members = request.getTeamMembers();

        if (members == null || members.isEmpty()) {
            return;
        }

        for (TeamMemberRequest memberRequest : members) {
            if (memberRequest.getName() == null
                    || memberRequest.getName().isBlank()) {
                continue;
            }

            TeamMember member = new TeamMember();
            member.setFounderId(founder.getId());
            member.setName(memberRequest.getName());
            member.setRole(memberRequest.getRole());
            member.setEmail(memberRequest.getEmail());
            member.setMobile(memberRequest.getMobile());
            member.setEquityPercentage(
                    memberRequest.getEquityPercentage());
            member.setLinkedinProfile(
                    memberRequest.getLinkedinProfile());
            member.setExperience(memberRequest.getExperience());

            teamMemberRepository.save(member);
        }
    }
}
