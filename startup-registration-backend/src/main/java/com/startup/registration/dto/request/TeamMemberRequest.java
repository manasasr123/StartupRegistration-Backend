
package com.startup.registration.dto.request;

import java.math.BigDecimal;

public class TeamMemberRequest {

    private String name;
    private String role;
    private String email;
    private String mobile;
    private BigDecimal equityPercentage;
    private String linkedinProfile;
    private String experience;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public BigDecimal getEquityPercentage() { return equityPercentage; }
    public void setEquityPercentage(BigDecimal equityPercentage) {
        this.equityPercentage = equityPercentage;
    }

    public String getLinkedinProfile() { return linkedinProfile; }
    public void setLinkedinProfile(String linkedinProfile) {
        this.linkedinProfile = linkedinProfile;
    }

    public String getExperience() { return experience; }
    public void setExperience(String experience) { this.experience = experience; }
}
