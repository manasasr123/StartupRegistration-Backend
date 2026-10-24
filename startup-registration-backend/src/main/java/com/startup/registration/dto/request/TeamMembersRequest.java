
package com.startup.registration.dto.request;

import java.util.List;

public class TeamMembersRequest {

    private Long founderId;
    private List<TeamMemberRequest> teamMembers;

    public Long getFounderId() {
        return founderId;
    }

    public void setFounderId(Long founderId) {
        this.founderId = founderId;
    }

    public List<TeamMemberRequest> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<TeamMemberRequest> teamMembers) {
        this.teamMembers = teamMembers;
    }
}
