
package com.startup.registration.service.impl;

import org.springframework.stereotype.Service;

import com.startup.registration.dto.request.StartupDetailsRequest;
import com.startup.registration.entity.Founder;
import com.startup.registration.entity.FounderProfile;
import com.startup.registration.repository.FounderProfileRepository;
import com.startup.registration.repository.FounderRepository;
import com.startup.registration.service.FounderProfileService;

@Service
public class FounderProfileServiceImpl implements FounderProfileService {

    private final FounderProfileRepository profileRepository;
    private final FounderRepository founderRepository;

    public FounderProfileServiceImpl(
            FounderProfileRepository profileRepository,
            FounderRepository founderRepository) {
        this.profileRepository = profileRepository;
        this.founderRepository = founderRepository;
    }

    @Override
    public void saveFounderProfile(StartupDetailsRequest request) {

        Founder founder = founderRepository.findById(request.getFounderId())
                .orElseThrow(() ->
                        new RuntimeException("Founder not found: "
                                + request.getFounderId()));

        FounderProfile profile = profileRepository.findByFounder(founder)
                .orElseGet(FounderProfile::new);

        profile.setFounder(founder);
        profile.setDesignation(request.getDesignation());
        profile.setLinkedin(request.getLinkedIn());
        profile.setExperience(request.getExperience());
        profile.setQualification(request.getQualification());
        profile.setPreviousStartup(request.getPreviousStartup());
        profile.setBio(request.getBio());

        String skills = request.getSkills() == null
                ? ""
                : String.join(",", request.getSkills());

        profile.setSkills(skills);

        profileRepository.save(profile);
    }
}
