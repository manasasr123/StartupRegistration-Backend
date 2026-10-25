
package com.startup.registration.controller;

import com.startup.registration.dto.request.StartupDetailsRequest;
import com.startup.registration.entity.FounderProfile;
import com.startup.registration.repository.FounderRepository;
import com.startup.registration.repository.FounderProfileRepository;
import com.startup.registration.service.FounderProfileService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/founder-profiles")
public class FounderProfileController {

    private final FounderProfileService founderProfileService;
    private final FounderRepository founderRepository;
    private final FounderProfileRepository founderProfileRepository;

    public FounderProfileController(
            FounderProfileService founderProfileService,
            FounderRepository founderRepository,
            FounderProfileRepository founderProfileRepository) {
        this.founderProfileService = founderProfileService;
        this.founderRepository = founderRepository;
        this.founderProfileRepository = founderProfileRepository;
    }

    @GetMapping("/founder")
    public ResponseEntity<FounderProfile> getFounderProfile(
            @RequestParam String email) {

        return founderRepository.findByEmail(email)
                .flatMap(founderProfileRepository::findByFounder)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveFounderProfile(
            @RequestBody StartupDetailsRequest request) {

        founderProfileService.saveFounderProfile(request);
        return ResponseEntity.ok("Founder profile saved successfully");
    }
}
