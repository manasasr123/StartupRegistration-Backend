
package com.startup.registration.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "team_members")
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "founder_id", nullable = false)
    private Long founderId;

    private String name;
    private String role;
    private String email;
    private String mobile;

    @Column(name = "equity_percentage", precision = 5, scale = 2)
    private BigDecimal equityPercentage;

    @Column(name = "linkedin_profile")
    private String linkedinProfile;

    private String experience;

    public TeamMember() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getFounderId() { return founderId; }
    public void setFounderId(Long founderId) { this.founderId = founderId; }

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
